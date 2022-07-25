package com.kangyi.util;

//import com.kangyi.mapper.GuiJi123Mapper;
import com.kangyi.mapper.GuiJiMapper;
import com.kangyi.pojo.GuiJi;
import com.kangyi.pojo.Order;
import com.kangyi.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.kangyi.constant.Constant.PACHONG_ADMINID;
import static com.kangyi.util.GuijiJingWeiDU.getGuijiJingWeiDu;
import static com.kangyi.util.ManyUrlKeyUtil.getUrl;
import static com.kangyi.util.StringTest.ifCity;
import static com.kangyi.util.StringTest.isJsonObject;
import static com.kangyi.util.StringToDate.YRDateString;
import static com.kangyi.util.StringToDate.dateAddTian;
import static com.kangyi.util.futureUtil.addGuijiListOnThrea;
import static com.kangyi.util.futureUtil.getGuijiListOnThrea;
//@MapperScan(basePackages = "com.kangyi.mapper")
@Service

public class GetListGuiji {
//    @Autowired
//    static GuiJi123Mapper guiJi123Mapper;

    @Autowired
    OrderService orderService;

    @Autowired
    GuiJiMapper guiJiMapper;

    static Long orderId= Long.valueOf( 111 );

    static int num=0;
    public  static List<GuiJi> getListGuiji(String prov,String city ) throws Exception {
        List<GuiJi> guiJiList = new ArrayList<>();
        String guijiurl="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData";
        String jingweiurl = "https://apis.map.qq.com/ws/geocoder/v1/?key=JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS&address=";
        if(prov!=null&&city!=null){
            guijiurl = "https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&prov=" + prov + "" + "&city=" + city;
        }
        long startTime1 = System.currentTimeMillis();
        String s = HttpURLConnectionUtil.doGet( guijiurl );
//        String s = HttpClientUtil.doGet( guijiurl );
//
//        String s = HttpRemoteUtil.getHttpRequest( guijiurl );
        System.out.println("@调用jingweiurl耗时 : " + (System.currentTimeMillis() - startTime1) );
        JSONObject json_s = JSONObject.fromObject(s);
        JSONObject json_data  = json_s.getJSONObject( "data" );
        if (!"null".equals( json_data.toString() )&&json_data!=null){
//        JSONObject json_data = JSONObject.fromObject(data);
            net.sf.json.JSONArray  list = json_data.getJSONArray( "list" );


            JSONArray jsonArray = new JSONArray();
            String time=null;
            /*
             * 一个城市一个list，每个list可能有多条desc
             *
             * */
            for (int i=0;i<list.size();i++){
                String desc =  list.getJSONObject( i ).get( "desc" ).toString();
                try {
                    Map<String, String> descMap = StringTest.StringChange( desc );
//               System.out.println("@#$5  "+descMap);
                    Set<String> strings = descMap.keySet();
//               Set<String> urls = new HashSet<> ();
//               urls.add( url );

                    /*
                     * 判断每个desc的地名多个
                     *
                     * */
//
                    for (String a:strings) {
                        num++;
                        jingweiurl = getUrl(num );
                        time = descMap.get( a );
//                   String jingwei = HttpClientUtil.doGet( jingweiurl + prov + city + a );
//                   JSONObject json_jingwei = JSONObject.fromObject(jingwei);
//                   GuiJi guiJi = getGuijiJingWeiDu( json_jingwei, time );
//                   guiJiList.add( guiJi );

                        String url = jingweiurl + prov + city + a;
                        JSONObject jsonUrl = new JSONObject();
                        jsonUrl.put( "requestUrl", url );
                        jsonArray.add( jsonUrl );
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            guiJiList.addAll( getGuijiListOnThrea( jsonArray, time ) );
//          System.out.println("@#$jsonArray "+jsonArray.size());
        }else {
            throw new Exception("查不到轨迹!");
        }
        return guiJiList;
    }


//    @Async("MyThreadPool")
//    public  void addListGuiji1(Integer page) {
//        System.out.println("addListGuiji1");
//    }
//
//    @Async("MyThreadPool")
//    public  void addListGuiji2(Integer page) {
//        System.out.println("addListGuiji2");
//    }


    //    @Async("MyThreadPool")
    public  List<GuiJi> addListGuiji(Integer page) throws Exception {
        List<GuiJi> guiJiList = new ArrayList<>();
        String guijiurl="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData";
        String jingweiurl = "https://apis.map.qq.com/ws/geocoder/v1/?key=JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS&address=";
        if(page!=null){
            guijiurl = "https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&page=" + page ;
        }
        long startTime1 = System.currentTimeMillis();
        String s = HttpURLConnectionUtil.doGet( guijiurl );
//                String s = "{\"status\":0,\"msg\":\"succ\",\"data\":{\"totalPage\":9,\"nowPage\":1,\"list\":[{\"title\":\"疑似现居于龙岗区\",\"desc\":\"【5月9日】5月9日龙岗区坂田街道万科第五园八期5月9日小荔饺子生活馆（塘朗宝能城花园店）5月9日贰麻酒馆（红山6979玻璃屋店）5月9日蚊子の聚乐部5月9日南山智园崇文园区5月9日食其家·牛丼咖喱（缤果空间店）5月9日耐克（深圳北站店）5月9日beer798（中梅路）5月9日宝安区航城街道南航明珠花园5月9日回家乡餐馆（塘岭路店）\",\"prov\":\"广东\",\"city\":\"深圳\"},{\"title\":\"\",\"desc\":\"【4月13日】1月8日益佳亿24h便利店（南山大道店）1月7日维也纳酒店南山亿利达店1月6日欢迎专业美发（龙尾路）1月5日家乐福（梅林店）1月4日海王星辰（龙尾店）1月3日海王星辰（梅中路店）1月2日海天综合大厦1月1日大唐靓汤（红荔西路店）12月31日四季山水花园二期\",\"prov\":\"广东\",\"city\":\"深圳\"},{\"title\":\"疑似现居于元氏县\",\"desc\":\"【4月15日】4月15日平顶山服务区4月15日元氏新元高速服务区\",\"prov\":\"河北\",\"city\":\"石家庄\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【5月9日】5月9日安盛购物广场六楼亚惠快餐5月9日瑞柏中心3号楼23楼5月9日金州区第一人民医院5月9日安盛购物广场五楼半亩良田5月9日安盛购物广场5月9日金州新玛特（斯大林路284号）五楼床品卖场5月9日久喜和风烘培（光明街道北山路1416号福佳新天地广场一层北区D4-1）5月9日瑞柏中心地下一层盒马鲜生5月9日安盛购物广场六楼鸡公煲5月9日兴达海鲜食府（金州和平路480号）5月9日光明市场5月9日胖姐包子铺（斯大林路店）5月9日丽人美容店\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月18日】4月18日一诺通讯（金州店）4月18日西山屯站4月18日御龙湾站4月18日胖姐包子铺（金纺店）4月18日金州步行街4月18日向应公园北门4月18日鑫嘉兴超市4月18日中国建设银行（南街支行）ATM机4月18日诺杯鲜饮（斯大林路店）4月18日美味多时尚回转小火锅（步行街店）4月18日向应广场站4月18日标头烤面筋（斯大林路）4月18日旺龙超市（金泉路店）4月18日楚成商店（金普新区响泉街）\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【4月17日】4月17日华铁工业园4月17日永洪水洗厂4月17日百慧超市4月17日友谊旧物市场\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【4月15日】4月15日胖姐包子铺（金纺店）4月15日隐麦手擀面（金普新区站前街道联胜社区斯大林路536-7号）4月15日龙王庙淮南牛肉汤（龙王店）4月15日乐哈哈超市（金海国际店）4月15日康居小区15号楼菜鸟驿站4月15日向应广场站4月15日美粥乐营养早餐店4月15日金纺市场东门大发粮油店4月15日中国建设银行（南街支行）ATM机4月15日龙王庙村站4月15日美味多时尚回转小火锅（步行街店）4月15日开发区中国银行二楼4月15日楼上楼酒馆4月15日中国邮政储蓄银行（滨海公路）4月15日中国石油（金港路店）4月15日龙王庙八珍熟食（龙山路店）4月15日八大碗（开发区黄海西路店）4月15日金发地批发市场4月15日龙王庙市场4月15日础明冷鲜肉店\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月15日】4月12日解放广场站4月12日金州火车站4月12日万科城菜鸟驿站4月12日五一广场站4月12日天天鲜饺子王(沙河口区五一路)4月12日百味品芳轩(金纺万科城店)4月12日荣民街路口4月12日寺儿沟站4月12日二七广场站4月12日万科城4月12日家家福超市(金普新区五一路店)4月12日中山广场站4月12日绿波小区站4月12日泡崖市场4月12日泡崖八区幼儿园站4月12日大同街站4月12日旅顺华酝牡丹园(旅顺口区长城街道赵家村花溪街北侧)4月12日万众广场4月12日亿达生鲜超市(万科城店)4月12日极品汇农超大市场(沙河口区解放广场)\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"疑似现居于金州区\",\"desc\":\"【4月14日】4月14日美粥乐营养早餐店4月14日恒民生鲜（金海国际店）4月14日线食煮益过桥米线（大连总店）4月14日金连佳地B座4月14日金海国际花园（南门）站4月14日康居小区5号楼4月14日佳乐购生鲜超市4月14日汝运刀削面总店4月14日东纬路站4月14日大湾市场4月14日华南北站4月14日艾易特仓储超市（金海明珠店）4月14日南山市场4月14日福祥古风文化摄影4月14日乐哈哈超市（金海国际店）4月14日中医院站4月14日千山路站4月14日金海购物超市4月14日龙王庙市场4月14日建设银行自助银行（大连高城山支行）4月14日金州步行街\",\"prov\":\"辽宁\",\"city\":\"大连\"},{\"title\":\"\",\"desc\":\"【5月7日】5月7日豫中桂园5月7日殷村\",\"prov\":\"河南\",\"city\":\"许昌\"}]}}";

        System.out.println(page+"页 调用m.sm.cn/api耗时 : " + (System.currentTimeMillis() - startTime1) );
        if (!isJsonObject(s)){
            System.out.println("解析guijiurl失败，无内容");
            return null;
        }
        JSONObject json_s = JSONObject.fromObject(s);
        JSONObject json_data  = json_s.getJSONObject( "data" );
        if ("null".equals( json_data.toString() )||json_data==null){
            System.out.println("查不到轨迹!");
            return null;
        }

//        JSONObject json_data = JSONObject.fromObject(data);
        net.sf.json.JSONArray  list = json_data.getJSONArray( "list" );
        JSONArray jsonArray = new JSONArray();
        ArrayList<Long> orderIdList = new ArrayList<Long>();
        Map<String, String> newMap = new HashMap<>();
        ArrayList<String> timeList=new ArrayList<String>(  );
//            String time=null;
        /*
         * 一个城市一个list，每个list可能有多条desc
         *
         * */
        for (int i=0;i<list.size();i++){


            String desc =  list.getJSONObject( i ).get( "desc" ).toString();
            String ydata = list.getString( i );
            orderId = orderService.insertOrder( PACHONG_ADMINID, 4, 2, ydata);
//                System.out.println("orderId   "+orderId);
            Order order = orderService.selectOneById( orderId );
            if (order==null||"null".equals( order )||orderId==0l){
                System.out.println("数据重复");
                continue;
            }

//                String prov =  list.getJSONObject( i ).get( "prov" ).toString();
            String city = ifCity(list.getJSONObject( i ).get( "city" ).toString());
            try {
                if(!desc.contains( "【" )) {
                    System.out.println("少了中括号!  "+s);
                    System.out.println( list+"少了中括号!" );

                }
                Map<String, String> descMap = StringTest.StringChange( desc );

//               System.out.println("@#$5  "+descMap);
                Set<String> strings = descMap.keySet();
//               Set<String> urls = new HashSet<> ();
//               urls.add( url );

                /*
                 * 判断每个desc的地名多个
                 *
                 * */
//
                for (String a:strings) {


                    num++;
                    jingweiurl = getUrl(num );
                    timeList.add( descMap.get( a ) );
                    String url = jingweiurl  + city + a;
                    JSONObject jsonUrl = new JSONObject();
                    jsonUrl.put( "requestUrl", url );
                    jsonArray.add( jsonUrl );
                    orderIdList.add( orderId );

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        guiJiList = addGuijiListOnThrea( jsonArray ,timeList,orderIdList );


        if (guiJiList==null||guiJiList.size()<=0){
            System.out.println("无轨迹数据加入 "+s);
            num=0;
            return null;
        }
        int i1 = guiJiMapper.insertList( guiJiList );
        num=0;
        System.out.println(i1+"个轨迹加入数据库完毕");
        return guiJiList;
    }


//    public static void main(String[] args) throws Exception {
//
////        GuiJi123Mapper guiJi123Mapper;
//        long startTime = System.currentTimeMillis();
//        Date date1 = new Date();
//        String prov="浙江省";
//        String city="杭州市";
//        List<GuiJi> listGuiji = getListGuiji( prov, city );
////        List<GuiJi> listGuiji = (List<GuiJi>) addListGuiji( 16);
//        System.out.println(num+" num "+listGuiji.size()+"   "+listGuiji);
//        long insertTime = System.currentTimeMillis();
////        guiJi123Mapper.insertList(listGuiji);
//        long insertTime1 = System.currentTimeMillis();
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("11总耗时 : " + (endTime - startTime)+"  insertTime  "+(insertTime-insertTime1) );
//        System.out.println(date1+" data "+new Date(  ));
//
//    }

}
