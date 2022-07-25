package com.kangyi;

//import com.kangyi.mapper.GuiJi123Mapper;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.kangyi.mapper.GuiJiMapper;
import com.kangyi.mapper.HeSuanMapper;
import com.kangyi.mapper.OrderMapper;
import com.kangyi.pojo.*;
import com.kangyi.redisRepository.GuijiRepository;
import com.kangyi.service.CommentService;
import com.kangyi.service.OrderService;
import com.kangyi.service.QuartzBeanService;
import com.kangyi.service.impl.GuiJiServiceImpl;
import com.kangyi.util.*;
import com.kangyi.util.jsoup.JsoupUtil;
import com.kangyi.util.jsoup.ResultGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

import static com.kangyi.constant.Constant.PACHONG_ADMINID;
import static com.kangyi.util.ManyUrlKeyUtil.getUrl;
import static com.kangyi.util.StringTest.ifCity;
import static com.kangyi.util.StringTest.isJsonObject;
import static com.kangyi.util.StringToDate.YMDmsToDate;
import static com.kangyi.util.StringToDate.dateAddTian;
import static com.kangyi.util.futureUtil.addGuijiListOnThrea;
//import static com.kangyi.util.GetListGuiji.addListGuiji;

@SpringBootTest
class
Kangyi01ApplicationTests {

    @Autowired
    GetListGuiji getListGuiji;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    HeSuanMapper heSuanMapper;

    @Autowired
    GuiJiMapper guiJiMapper;

    @Autowired
    QuartzBeanService quartzBeanService;

    @Autowired
    GuijiRepository guijiRepository;

    @Autowired
    GuiJiServiceImpl guiJiService;

    @Autowired
    CommentService commentService;


//
//    @Test
//    void contextLoads() {
////        Map<String, Object> pageResult =orderService.getListForPage( 1,10, (long) 1,null,null );
////        System.out.println(pageResult);
////        System.out.println("22");
//
//        HeSuanExample heSuanExample = new HeSuanExample();
//        HeSuanExample.Criteria criteria = heSuanExample.createCriteria();
//        List<HeSuan> heSuans = heSuanMapper.selectByOrderStatusAndExample( heSuanExample);
//        System.out.println(heSuans);
//    }
//
////    @Transactional
//    @Test
//    void aaddListGuiji() {
//        long startTime = System.currentTimeMillis();
//        Date date1 = new Date();
//        String prov = "浙江省";
//        String city = "杭州市";
//        //        List<GuiJi> listGuiji = getListGuiji( prov, city );
//        List<GuiJi> listGuiji = null;
//        try {
//            long orderId = orderService.insertOrder( PACHONG_ADMINID, 4, 2 );
//           listGuiji = addListGuiji( 3 ,orderId);
//            int i = guiJi123Mapper.insertList( listGuiji );
//            System.out.println(orderId+" 插入 "+i);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(  " num " + listGuiji.size() + "   " + listGuiji );
//        long insertTime = System.currentTimeMillis();
//        guiJi123Mapper.insertList( listGuiji );
//        long insertTime1 = System.currentTimeMillis();
//
//        long endTime = System.currentTimeMillis();
//        System.out.println( "11总耗时 : " + (endTime - startTime) + "  insertTime  " + (insertTime1 - insertTime) );
//        System.out.println( date1 + " data " + new Date() );
//    }

//    @Test
//    void testAscn(){
//        try {
//            for(int i=0;i<10;i++) {
//                getListGuiji.addListGuiji( 1 );
//                System.out.println( "1" );
//                getListGuiji.addListGuiji1( 2 );
//                System.out.println( "2" );
//                getListGuiji.addListGuiji2( 3 );
//                System.out.println( "3" );
////            getListGuiji.addListGuiji( 4 );
////            System.out.println("4");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void TestaaddListGuiji() {
        System.out.println( "动态的定时任务执行时间：" + new Date().toLocaleString() );
//        List<GuiJi> guiJiList = new ArrayList<>();
        String guijiurl = "https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData";
        long startTime1 = System.currentTimeMillis();
        String s = JsoupUtil.JsoupGetData( guijiurl );
//        String s1 = HttpURLConnectionUtil.doGet( guijiurl );
////        String s = "{\"status\":0,\"msg\":\"succ\",\"data\":{\"totalPage\":9,\"nowPage\":1,\"list\":[{\"title\":\"疑似现居于龙岗区\",\"desc\":\"【5月9日】5月9日龙岗区坂田街道万科第五园八期5月9日小荔饺子生活馆（塘朗宝能城花园店）5月9日贰麻酒馆（红山6979玻璃屋店）5月9日蚊子の聚乐部5月9日南山智园崇文园区5月9日食其家·牛丼咖喱（缤果空间店）5月9日耐克（深圳北站店）5月9日beer798（中梅路）5月9日宝安区航城街道南航明珠花园5月9日回家乡餐馆（塘岭路店）\",\"prov\":\"广东\",\"city\":\"深圳\"},{\"title\":\"\",\"desc\":\"【4月13日】1月8日益佳亿24h便利店（南山大道店）1月7日维也纳酒店南山亿利达店1月6日欢迎专业美发（龙尾路）1月5日家乐福（梅林店）1月4日海王星辰（龙尾店）1月3日海王星辰（梅中路店）1月2日海天综合大厦1月1日大唐靓汤（红荔西路店）12月31日四季山水花园二期\",\"prov\":\"广东\",\"city\":\"深圳\"},{\"title\":\"疑似现居于元氏县\",\"desc\":\"【4月15日】4月15日平顶山服务区4月15日元氏新元高速服务区\",\"prov\":\"河北\",\"city\":\"石家庄\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【5月9日】5月9日安盛购物广场六楼亚惠快餐5月9日瑞柏中心3号楼23楼5月9日金州区第一人民医院5月9日安盛购物广场五楼半亩良田5月9日安盛购物广场5月9日金州新玛特（斯大林路284号）五楼床品卖场5月9日久喜和风烘培（光明街道北山路1416号福佳新天地广场一层北区D4-1）5月9日瑞柏中心地下一层盒马鲜生5月9日安盛购物广场六楼鸡公煲5月9日兴达海鲜食府（金州和平路480号）5月9日光明市场5月9日胖姐包子铺（斯大林路店）5月9日丽人美容店\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月18日】4月18日一诺通讯（金州店）4月18日西山屯站4月18日御龙湾站4月18日胖姐包子铺（金纺店）4月18日金州步行街4月18日向应公园北门4月18日鑫嘉兴超市4月18日中国建设银行（南街支行）ATM机4月18日诺杯鲜饮（斯大林路店）4月18日美味多时尚回转小火锅（步行街店）4月18日向应广场站4月18日标头烤面筋（斯大林路）4月18日旺龙超市（金泉路店）4月18日楚成商店（金普新区响泉街）\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【4月17日】4月17日华铁工业园4月17日永洪水洗厂4月17日百慧超市4月17日友谊旧物市场\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【4月15日】4月15日胖姐包子铺（金纺店）4月15日隐麦手擀面（金普新区站前街道联胜社区斯大林路536-7号）4月15日龙王庙淮南牛肉汤（龙王店）4月15日乐哈哈超市（金海国际店）4月15日康居小区15号楼菜鸟驿站4月15日向应广场站4月15日美粥乐营养早餐店4月15日金纺市场东门大发粮油店4月15日中国建设银行（南街支行）ATM机4月15日龙王庙村站4月15日美味多时尚回转小火锅（步行街店）4月15日开发区中国银行二楼4月15日楼上楼酒馆4月15日中国邮政储蓄银行（滨海公路）4月15日中国石油（金港路店）4月15日龙王庙八珍熟食（龙山路店）4月15日八大碗（开发区黄海西路店）4月15日金发地批发市场4月15日龙王庙市场4月15日础明冷鲜肉店\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月15日】4月12日解放广场站4月12日金州火车站4月12日万科城菜鸟驿站4月12日五一广场站4月12日天天鲜饺子王(沙河口区五一路)4月12日百味品芳轩(金纺万科城店)4月12日荣民街路口4月12日寺儿沟站4月12日二七广场站4月12日万科城4月12日家家福超市(金普新区五一路店)4月12日中山广场站4月12日绿波小区站4月12日泡崖市场4月12日泡崖八区幼儿园站4月12日大同街站4月12日旅顺华酝牡丹园(旅顺口区长城街道赵家村花溪街北侧)4月12日万众广场4月12日亿达生鲜超市(万科城店)4月12日极品汇农超大市场(沙河口区解放广场)\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月14日】4月14日美粥乐营养早餐店4月14日恒民生鲜（金海国际店）4月14日线食煮益过桥米线（大连总店）4月14日金连佳地B座4月14日金海国际花园（南门）站4月14日康居小区5号楼4月14日佳乐购生鲜超市4月14日汝运刀削面总店4月14日东纬路站4月14日大湾市场4月14日华南北站4月14日艾易特仓储超市（金海明珠店）4月14日南山市场4月14日福祥古风文化摄影4月14日乐哈哈超市（金海国际店）4月14日中医院站4月14日千山路站4月14日金海购物超市4月14日龙王庙市场4月14日建设银行自助银行（大连高城山支行）4月14日金州步行街\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【5月7日】5月7日豫中桂园5月7日殷村\",\"prov\":\"河南\",\"city\":\"许昌\"}]}}";
////        String s = HttpClientUtil.doGet( guijiurl );
////        String s = HttpRemoteUtil.getHttpRequest( guijiurl );
        System.out.println( "@调用jingweiurl耗时 : " + (System.currentTimeMillis() - startTime1) );
        JSONObject json_s = JSONObject.fromObject( s );
        JSONObject json_data = json_s.getJSONObject( "data" );
        if (!"null".equals( json_data.toString() ) && json_data != null) {
//        JSONObject json_data = JSONObject.fromObject(data);
            Integer totalPage = json_data.getInt( "totalPage" );
            if (totalPage != null) {
                for (int i = 1; i <= totalPage; i++) {
//                    guijiurl = "https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&page=" + i ;
                    try {
                        long startTime2 = System.currentTimeMillis();
//                        long order = orderService.insertOrder( PACHONG_ADMINID, 4, 2 );
//                        GetListGuiji getListGuiji = new GetListGuiji();
                        List<GuiJi> listGuiji = getListGuiji.addListGuiji( i );
//                        int i1 = guiJiMapper.insertList( listGuiji );
                        System.out.println( i + " /" + totalPage + " 加入此页耗时 : " + (System.currentTimeMillis() - startTime2) );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println( "@总耗时 : " + (System.currentTimeMillis() - startTime1) );

    }

    @Test
    public void testOrderService() {
        Map<String, Object> listForPage = orderService.getListForPage( 4, null, null, 1, 1000, 3l, null, null );
        List<Order> orders = (List<Order>) listForPage.get( "order" );
        for (Order order : orders) {
            String ydata = order.getHandelRemark();
            if (ydata!=null) {
                if (ydata.length() < 100) {
                    order.setUserRemark( ydata.substring( 0, ydata.length() - 1 ) );

                } else {
                    order.setUserRemark( ydata.substring( 0, 100 ) );
                }
                orderMapper.insertAndGetId( order );
                Long aLong =order.getOrderId();
                System.out.println( aLong );
            }

        }
    }
    @Test
    public void getQuarz(){
        Map<String, Object> listForPage = quartzBeanService.getListForPage( 0, null, 1, 20 );
        System.out.println(listForPage.get( "quartzBeans" ));
    }
    @Test
    public void testJsoup(){
        Object res = "";
        try {
            Document doc = Jsoup.connect("https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&page=1")
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)")
                    .header("content-type", "application/json")
                    .timeout(5000).get();
            res = JSONUtil.parseObj(doc.body().html());
//            res = JSONUtil.parseObj(doc.body().html()).get("data");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "@#$1  "+ResultGenerator.genSuccessResult( JSON.parse(res.toString())));
        System.out.println( "@#$2  "+ JSON.parse(res.toString()));
    }

    @Test
    public void testRedis(){

        Comment comment = new Comment();
        comment.setOrderId( -1l );
        comment.setContent( "hhh" );
        commentService.insertOne( comment );


//        guiJiService.selectOneById( 21201l );
//        GuiJi guiJi = guiJiService.selectOneById( 21201l );
//        System.out.println(guiJi);
//        orderService.selectOneById( 1872l );
//        Order order = orderService.selectOneById( 1872l );
//        System.out.println(order);


//        String handelRemark = order.getHandelRemark();
//        JSONObject json_qiege = JSONObject.fromObject(handelRemark);
//        String desc = json_qiege.getString( "desc" );
//        try {
//            String qiekai = StringTest.StringChangeJSON( desc );
//            System.out.println(qiekai);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        GuiJi guiJi = new GuiJi();
//        guiJi.setGuijiId( -1l );
//        String key="@#$"+guiJi.getGuijiId();
//        guijiRepository.saveObject( key,guiJi );
//        GuiJi object1 = (GuiJi) guijiRepository.getObject( key );
//        System.out.println("@#$ "+object1);
    }

    //    @Transactional
    @Test
    public void testUpdateGuiji(){

        GuiJiExample guiJiExample = new GuiJiExample();
        GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
//        criteria.andUserIdBetween( 0l,100l );
//        criteria.andUserIdEqualTo( 3l );
        criteria.andGuijiIdNotEqualTo( 2l );
//        criteria.andGuijiIdGreaterThanOrEqualTo(  )
        List<GuiJi> guiJiList = guiJiMapper.selectByExample( guiJiExample );

//        List<GuiJi> guiJiList2 =new ArrayList<GuiJi>(  );
        int j=0;
        int i=0;
        for (GuiJi guiJi:guiJiList){
//            GuiJi guiJi2 = new GuiJi();
//            guiJi2.setGuijiId( guiJi.getGuijiId() );
            guiJi.setEnddate( dateAddTian( guiJi.getEndtime(),30  ) );
//            guiJi.setEnddate( dateAddTian( guiJi.getEndtime(), 30 ) );
//            System.out.println(guiJi);
//            criteria.andGuijiIdEqualTo( guiJi.getGuijiId() );
//            i += guiJiMapper.updateByExampleSelective( guiJi, guiJiExample );
            i +=  guiJiMapper.updateByPrimaryKeySelective( guiJi );
//            guiJiList2.add( guiJi2 );
            j++;
        }
//        int i = guiJiMapper.updateListByPrimaryKeySelective( guiJiList2 );

        System.out.println(i+"  j"+j);
    }

//    @Test
//    public void testcomment(){
//        Comment comment = new Comment();
//        comment.setContent( "hhh" );
//        int i=commentService.insertOne(comment);
//        System.out.println(i);
//    }

    //    @Transactional
    @Test
    public void  testdeleteGuijiAndOrder() {
        //批量删除轨迹
        GuiJiExample guiJiExample = new GuiJiExample();
        GuiJiExample.Criteria criteria = guiJiExample.createCriteria();
        criteria.andGuijiIdBetween( 1590l, 79346l );
        criteria.andUserIdEqualTo( 3l );
        List<GuiJi> guiJiList1 = guiJiMapper.selectByExample( guiJiExample );
//        int i = guiJiMapper.deleteByExample( guiJiExample );
//        System.out.println(i);
        int num = 0;
        for (GuiJi guiJi : guiJiList1) {
            JSONArray jsonArray = new JSONArray();
            ArrayList<Long> orderIdList = new ArrayList<Long>();
            ArrayList<String> timeList = new ArrayList<String>();
            List<GuiJi> guiJiList = new ArrayList<>();

            Long orderId1 = guiJi.getOrderId();
            if (orderId1==0l||orderId1==null)
            {
                guiJiMapper.deleteByPrimaryKey( guiJi.getGuijiId() );
                continue;
            }

            Order order = orderService.selectOneById( orderId1 );
            if (order==null){
                guiJiMapper.deleteByPrimaryKey( guiJi.getGuijiId() );
                continue;
            }
            String handelRemark = order.getHandelRemark();
            if (handelRemark==null||"null".equals( handelRemark )){
//                System.out.println("h 空");
                continue;
            }
//            System.out.println("    h "+handelRemark);

            if (!isJsonObject(handelRemark)){
                continue;
            }
            JSONObject jsonObject = JSONObject.fromObject( handelRemark );
//            System.out.println("   json  "+jsonObject);
            String  desc = jsonObject.getString( "desc" );
            if (desc==null||"null".equals( desc )){
                continue;
            }else {
                //这个轨迹的订单有desc,但是没有覆盖这条，说明这个的时间出错了
                guiJiMapper.deleteByPrimaryKey( guiJi.getGuijiId() );

            }
            Long orderId = order.getOrderId();

            String city = ifCity( jsonObject.get( "city" ).toString() );
            try {
                if (!desc.contains( "【" )) {
                    System.out.println( "少了中括号!  " + desc );
//                    System.out.println( list+"少了中括号!" );
                }
                Map<String, String> descMap = StringTest.StringChange( desc );

                Set<String> strings = descMap.keySet();
                for (String a : strings) {
                    num++;
                    String jingweiurl = getUrl( num );
                    timeList.add( descMap.get( a ) );
                    String url = jingweiurl + city + a;
                    JSONObject jsonUrl = new JSONObject();
                    jsonUrl.put( "requestUrl", url );
                    jsonArray.add( jsonUrl );
                    orderIdList.add( orderId );

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
//            List<GuiJi> guiJiList1 = null;
            try {
                guiJiList = futureUtil.addGuijiListOnThrea( jsonArray, timeList, orderIdList );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (guiJiList == null||guiJiList.size()<=0||"null".equals( guiJiList )) {
                System.out.println( "解析失败" );
                System.out.println( num + "个  " + desc );
                continue;
            }
//            guiJiList.addAll( guiJiList );
//            int i1 = guiJiMapper.insertList( guiJiList );

            int i1 = guiJiMapper.genxinList( guiJiList );
            System.out.println("guijiId"+guiJi.getGuijiId());
            System.out.println( "orderId "+order.getOrderId()+"   共"+i1 + "个轨迹更新数据库完毕" );
            System.out.println(" guijiList  "+guiJiList);
        }

    }

    @Test
    public void  testUpdateOneGuijiAndOrder() {

        OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria1 = orderExample.createCriteria();
        criteria1.andUserIdEqualTo( 3l );
//        criteria1.andOrderIdEqualTo( 10043l );
//        criteria1.andInsertTimeBetween(YMDmsToDate("2022-05-09 18:56:26"),YMDmsToDate("2022-05-25 12:23:11" ));
        List<Order> orderList = orderMapper.selectByExample( orderExample );

//        net.sf.json.JSONArray  list = json_data.getJSONArray( "list" );

        int num = 0;
        for (Order order : orderList) {
            JSONArray jsonArray = new JSONArray();
            ArrayList<Long> orderIdList = new ArrayList<Long>();
            ArrayList<String> timeList = new ArrayList<String>();
            List<GuiJi> guiJiList = new ArrayList<>();
            String handelRemark = order.getHandelRemark();
            if (handelRemark==null||"null".equals( handelRemark )){
//                System.out.println("h 空");
                continue;
            }
//            System.out.println("    h "+handelRemark);

            if (!isJsonObject(handelRemark)){
                continue;
            }
            JSONObject jsonObject = JSONObject.fromObject( handelRemark );
//            System.out.println("   json  "+jsonObject);
            String  desc = jsonObject.getString( "desc" );
            if (desc==null||"null".equals( desc )){
                continue;
            }
            Long orderId = order.getOrderId();

            String city = ifCity( jsonObject.get( "city" ).toString() );
            try {
                if (!desc.contains( "【" )) {
                    System.out.println( "少了中括号!  " + desc );
//                    System.out.println( list+"少了中括号!" );
                }
                Map<String, String> descMap = StringTest.StringChange( desc );

                Set<String> strings = descMap.keySet();
                for (String a : strings) {
                    num++;
                    String jingweiurl = getUrl( num );
                    timeList.add( descMap.get( a ) );
                    String url = jingweiurl + city + a;
                    JSONObject jsonUrl = new JSONObject();
                    jsonUrl.put( "requestUrl", url );
                    jsonArray.add( jsonUrl );
                    orderIdList.add( orderId );

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
//            List<GuiJi> guiJiList1 = null;
            try {
                guiJiList = futureUtil.addGuijiListOnThrea( jsonArray, timeList, orderIdList );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (guiJiList == null||guiJiList.size()<=0||"null".equals( guiJiList )) {
                System.out.println( "解析失败" );
                System.out.println( num + "个  " + desc );
                continue;
            }
//            guiJiList.addAll( guiJiList );
//            int i1 = guiJiMapper.insertList( guiJiList );

            int i1 = guiJiMapper.genxinList( guiJiList );
            System.out.println( "orderId "+order.getOrderId()+"   共"+i1 + "个轨迹更新数据库完毕" );
            System.out.println(" guijiList  "+guiJiList);
        }
    }

    @Test
    public void test1(){

        Comment comment = commentService.selectOneById( 46l );
        System.out.println(comment.getTypeName());
    }






}





