package com.kangyi.service.impl;

//import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kangyi.mapper.*;
import com.kangyi.pojo.*;
import com.kangyi.service.GuiJiService;
import com.kangyi.service.HeSuanService;
import com.kangyi.service.OrderService;
import com.kangyi.util.ChangeChar;
import com.kangyi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kangyi.util.StringToDate.YMDmToDate;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
     OrderMapper orderMapper;
    @Autowired
    HeSuanMapper heSuanMapper;
    @Autowired
    GuiJiMapper guiJiMapper;
    @Autowired
    YiMiaoMapper yiMiaoMapper;
    @Autowired
    GeLiMapper geLiMapper;

    @Autowired
    GuiJiService guiJiService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Map<String, Object> getListForPage(int type, String btime, String etime, int pno, int psize, Long userId, String sortField, String sortType) {

        Page<Order> p = PageHelper.startPage( pno, psize );

        OrderExample oe = new OrderExample();
        OrderExample.Criteria criteria = oe.createCriteria();

        if(sortField!=null&&sortField.trim().length()>0){
            oe.setOrderByClause(ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

        }

        if(userId != null&&userId!=-1l){
            if(userId==0l){
                criteria.andUserIdNotEqualTo( 3l );
//                System.out.println("@#$非扒取信息");
            }else {
                criteria.andUserIdEqualTo( userId );
            }
//            System.out.println("@#$orderlist userid "+userId);
        }

        if(type >0 && type < 5){
            criteria.andTypeEqualTo( type );
//            System.out.println("@#$orderlist type "+type);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTimeDate = null;
        if(btime!=null){
            beginTimeDate=YMDmToDate(btime);
//            btime = btime + " 00:00:00";
//            try {
//                beginTimeDate = sdf.parse(btime);
//            } catch (ParseException e) {
//                beginTimeDate = null;
////                System.out.println("日期空的");
//            }
//            criteria.andInsertTimeGreaterThanOrEqualTo(beginTimeDate);
        }
        Date endTimeDate = null;
        if(etime!=null){
            endTimeDate=YMDmToDate(etime);
//            etime = etime + " 23:59:59";
//            try {
//                endTimeDate = sdf.parse(etime);
//                System.out.println("@#$y etime: "+etime);
//            } catch (ParseException e) {
//                beginTimeDate = null;
////                System.out.println("日期空的");
//                System.out.println("@#$x etime: "+etime);
//
//            }
//            criteria.andInsertTimeLessThanOrEqualTo(endTimeDate);
        }
                if(beginTimeDate != null && endTimeDate != null){
            criteria.andInsertTimeBetween( beginTimeDate,endTimeDate );
        }

        if(sortField!=null&&sortField.trim().length()>0){
            oe.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

        }

        List<Order> orders = orderMapper.selectByExample( oe );

        Map<String, Object> map = new HashMap<>(3);

        map.put("order", orders);
        map.put("pno", pno);
        map.put("psize", psize);
        map.put("count", p.getTotal());
        return map;

    }

    @Override
    public long insertOrder(Long userId, int type) {
        Order order = new Order();
        order.setUserId( userId );
        order.setType( type );
        order.setStatus( 1 );
        order.setInsertTime( new Date(  ) );
        orderMapper.insertAndGetId( order );
        Long orderId = order.getOrderId();

        return orderId;
    }

    @Override
    public long insertOrder(Long userId, int type,int status,String ydata) {
//        System.out.println("@#$!!!");

        Order order = new Order();
        order.setHandelRemark( ydata );
        if (ydata.length()<100){
            order.setUserRemark( ydata.substring( 0, ydata.length()-1 ) );

        }else {
            order.setUserRemark( ydata.substring( 0, 100 ) );
        }
//        System.out.println("@#$2"+order);
        order.setUserId( userId );
        order.setType( type );
        order.setStatus( status );
        order.setInsertTime( new Date(  ) );
        orderMapper.insertAndGetId( order );
        Long orderId = order.getOrderId();
//        System.out.println("@#$orderId "+orderId);
        return orderId;
    }

    @Override
    public int updateTypeIdOrderById(long orderId, long typeId) {

        String key="OrderId:"+orderId;
        if(redisUtil.exists( key )) {
            redisUtil.del( key );
        }
        Order order = new Order();
        order.setTypeId( typeId );
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdEqualTo( orderId );

        int i = orderMapper.updateByExampleSelective( order, orderExample );

        return i;
    }

    @Override
    public int updateAllOrderById(Order order) {
        Long orderId = order.getOrderId();
        String key="OrderId:"+orderId;
        if(redisUtil.exists( key )) {
            redisUtil.del( key );
        }
        order.setUpdateTime( new Date( ) );
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdEqualTo( orderId );

        int i = orderMapper.updateByExampleSelective( order, orderExample );
        return i;

    }

    @Override
    public int delectOneById(Long orderId) {

        String key="OrderId:"+orderId;
        if(redisUtil.exists( key )) {
            redisUtil.del( key );
        }

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andOrderIdEqualTo( orderId );

        return orderMapper.deleteByExample( orderExample);

    }

    @Override
    public int updateManyAllOrderById(List<Order> orderList) {
        int i=0;
        for (Order order:orderList){
            Long orderId = order.getOrderId();
            String key="OrderId:"+orderId;
        if(redisUtil.exists( key )) {
            redisUtil.del( key );
        }
            order.setUpdateTime( new Date( ) );
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria().andOrderIdEqualTo( orderId );

            i += orderMapper.updateByExampleSelective( order, orderExample );
        }
        return i;
    }

    @Override
    public Order selectOneById(Long orderId) {
        Order order1=new Order();
        String key="OrderId:"+orderId;
        if(redisUtil.exists( key )) {

            String o = (String) redisUtil.get( key );
             order1 = JSON.parseObject( o, Order.class );
            redisUtil.expire( key,24*60*60 );
//            System.out.println("@#$key,ok  "+order1);
        }else {
            OrderExample orderExample = new OrderExample();
            OrderExample.Criteria criteria = orderExample.createCriteria();
            criteria.andOrderIdEqualTo( orderId );
            List<Order> orders = orderMapper.selectByExample( orderExample );
            if (orders==null||orders.size()<=0){
                return null;
            }
            order1 = orders.get( 0 );
            redisUtil.set( key, JSON.toJSONString( order1 ),24*60*60 );
//            System.out.println("@#$key,no");
        }

        return order1;
    }

    @Override
    public Map<String, Object> getListForPageByIdList(Integer type, String btime, String etime, Integer pno, Integer psize, List<Long> orderList, String sortField, String sortType, String gOrj) {
        Page<Order> p = PageHelper.startPage( pno, psize );

        OrderExample oe = new OrderExample();
        OrderExample.Criteria criteria = oe.createCriteria();

        if(orderList==null||orderList.size()<=0){
            return new HashMap<String, Object>(  );
        }
        criteria.andOrderIdIn( orderList );

        if(sortField!=null&&sortField.trim().length()>0){
            oe.setOrderByClause(ChangeChar.camelToUnderline(sortField,2) +" " +sortType);

        }

        if(type >0 && type < 5){
            criteria.andTypeEqualTo( type );
//            System.out.println("@#$orderlist type "+type);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginTimeDate = null;
        if(btime!=null){
            beginTimeDate=YMDmToDate(btime);
        }
        Date endTimeDate = null;
        if(etime!=null){
            endTimeDate=YMDmToDate(etime);
        }
        if(beginTimeDate != null && endTimeDate != null){
            criteria.andInsertTimeBetween( beginTimeDate,endTimeDate );
        }

        if(sortField!=null&&sortField.trim().length()>0){
            oe.setOrderByClause( ChangeChar.camelToUnderline(sortField,2) +" " +sortType);
        }

        List<Order> orders = orderMapper.selectByExample( oe );
        for (Order order:orders){
            if (order==null){
                break;
            }
            Integer t = order.getType();
            if (t==1){
                //hesuan
                Long typeId = order.getTypeId();
                HeSuan heSuan = heSuanMapper.selectByPrimaryKey( typeId );
                order.setTypeName( heSuan.getHesuanPosition() );

            }else if(t==2){
                Long typeId = order.getTypeId();
                YiMiao yiMiao = yiMiaoMapper.selectByPrimaryKey( typeId );
                order.setTypeName( yiMiao.getYimiaoPosition() );

            }else if(t==3){
                Long typeId = order.getTypeId();
                GeLi geLi = geLiMapper.selectByPrimaryKey( typeId );
                order.setTypeName( geLi.getGelidianPosition() );

            }else  if(t==4){
                Long orderId = order.getOrderId();
                Map<String, Object> manyByOrderId = guiJiService.getManyByOrderId( orderId );
                List<GuiJi> guiJis =(List<GuiJi>)manyByOrderId.get( "guiji" );
                if (guiJis.size()>0&&guiJis!=null){
                    GuiJi guiJi = guiJis.get( 0 );
                    order.setTypeName( guiJi.getGuijiPosition() );
                }
            }
        }

        Map<String, Object> map = new HashMap<>(3);

        map.put(gOrj, orders);
        map.put("pno", pno);
        map.put("psize", psize);
        map.put("count", p.getTotal());
        return map;

    }

    @Override
    public List<Order> selectManyByUserId(Long userId) {
        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUserIdEqualTo( userId );
        List<Order> orders = orderMapper.selectByExample( orderExample );

        return orders;
    }


}
