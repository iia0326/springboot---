package com.kangyi.service.impl;

import com.kangyi.mapper.GuiJiMapper;
import com.kangyi.pojo.GuiJi;
import com.kangyi.pojo.GuiJiExample;
import com.kangyi.redisRepository.GuijiRepository;
import com.kangyi.service.GuiJiService;
import com.kangyi.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.kangyi.util.StringToDate.*;
import static com.kangyi.util.StringToDate.YMDmsToDate;

@Service
public class GuiJiServiceImpl implements GuiJiService {


    @Autowired
    GuiJiMapper guiJiMapper;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    GuijiRepository guijiRepository;
    @Override
    public int insertListGuiJi(ArrayList<GuiJi> listGuiJi, long orderId, Long userId, int type) {
//        GuiJi guiJi = new GuiJi();
        int i=0;

        for (GuiJi guiJi:listGuiJi
             ) {
            guiJi.setUserId( userId );
            guiJi.setOrderId( orderId );
//            Date starttime = guiJi.getStarttime();
            Date endtime = guiJi.getEndtime();
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(endtime);
            cal.add(Calendar.DATE, 30);
            Date enddate =cal.getTime();
            guiJi.setEnddate( enddate );
            guiJi.setArea( YNDhmNewDateString() );
            i+=guiJiMapper.insert( guiJi );
//            Long guijiId = guiJi.getGuijiId();
//            System.out.println(guiJi);
//            listGuiJi.add( guiJi );
        }
//         i = guiJiMapper.insertList( listGuiJi );


        return i;
    }

    @Override
    public Map<String,Object>  getManyByOrderId(Long orderId) {
        Map<String, Object> map = new HashMap<>(3);
        GuiJiExample guiJiExample = new GuiJiExample();
        GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
        criteria.andOrderIdEqualTo( orderId );
//        map = (Map<String, Object>)guiJiMapper.selectByExample( guiJiExample );
        List<GuiJi> guiJis = guiJiMapper.selectByExample( guiJiExample ) ;




        map.put( "guiji",guiJis );

        return map;
    }

    @Override
    public int updateManyByOrderId(Long orderId, ArrayList<GuiJi> listGuiJi) {
        int i=0;

        for (GuiJi guiJi:listGuiJi
        ) {
            GuiJiExample guiJiExample = new GuiJiExample();
            GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
            Long guijiId = guiJi.getGuijiId();
           criteria.andGuijiIdEqualTo( guijiId );


            GuiJi guiJi1 = guiJiMapper.selectByPrimaryKey( guijiId );
            if (guiJi1==null){
                //如果没有这类似的数据就新增
                guiJi.setOrderId( orderId );
                guiJi.setArea( YNDhmNewDateString() );
                System.out.println("这是没有此轨迹，新增一下");
                i +=guiJiMapper.insert( guiJi );

            }else {


                criteria.andOrderIdEqualTo( orderId );
                guiJi.setArea( YNDhmNewDateString() );
                i += guiJiMapper.updateByExampleSelective( guiJi, guiJiExample );
            }
        }
        return i;



    }

    @Override
    public int delectManyByOrderId(Long orderId) {



        GuiJiExample guiJiExample = new GuiJiExample();
        GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
        criteria.andOrderIdEqualTo( orderId );
        int i = guiJiMapper.deleteByExample( guiJiExample );


        return i;
    }

    @Override
    public List<GuiJi> selectManyByJingWeiDu(BigDecimal bigWeiDu, BigDecimal smallWeiDu, BigDecimal bigJingDu, BigDecimal smalJingDu, String etime, String btime, Integer tian) {
        GuiJiExample guiJiExample = new GuiJiExample();
        GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
        criteria.andJinduBetween( smalJingDu,bigJingDu );
        criteria.andWeiduBetween( smallWeiDu,bigWeiDu );

        if (etime!=null&&!"null".equals( etime )&&etime.trim().length()>0){
            criteria.andEndtimeLessThan( YMDmToDate(etime) );
            criteria.andStarttimeGreaterThanOrEqualTo( YMDmToDate(btime) );
        }

        if (tian!=null&&tian>0){
            criteria.andEndtimeGreaterThanOrEqualTo( dateAddTian(new Date(  ),0-tian));
        }

        if ((tian==null||tian<=0)&&(etime==null||"null".equals( etime )||etime.trim().length()<=0)){
            criteria.andEnddateGreaterThanOrEqualTo( dateAddTian(new Date(  ),1));
        }

        List<GuiJi> guiJiList = guiJiMapper.selectByOrderStatusAndExample( guiJiExample );


        return guiJiList;
    }

    @Override
    public GuiJi selectOneById(Long typeId) {
        GuiJi guiJi=null;
        String key="guiji:"+typeId;
        System.out.println(key);
//        if (guijiRepository.exists( key )){
////            System.out.println("ok");
////            guiJi= (GuiJi) redisUtil.get( key );
//            guiJi= (GuiJi) guijiRepository.getObject( key );
////            System.out.println(object);
//
//        }else {
             guiJi = guiJiMapper.selectByPrimaryKey( typeId );
            redisUtil.set( key,guiJi );
            guijiRepository.saveObject( key,guiJi );
//            System.out.println("no");

//        }
        return guiJi;
    }
}
