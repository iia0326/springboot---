package com.kangyi.util;

//import com.alibaba.fastjson.JSONArray;
import com.kangyi.pojo.GuiJi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kangyi.constant.Constant.PACHONG_ADMINID;
import static com.kangyi.util.GuijiJingWeiDU.getGuijiJingWeiDu;
import static com.kangyi.util.StringToDate.YNDhmNewDateString;

public class futureUtil {


    String guijiurl1="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&prov=广东省&city=广州市";
    String guijiurl2="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&prov=辽宁省&city=大连市";
    String guijiurl3="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&prov=河北省&city=石家庄市";
    String jingweiurl = "https://apis.map.qq.com/ws/geocoder/v1/?key=JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS&address=";






    public static List<GuiJi> getGuijiListOnThrea(JSONArray r,String time) throws InterruptedException {
        //组合线程请求参数
        JSONArray result = r;
        ExecutorService execPool = Executors.newFixedThreadPool(result.size());
//        List<Future<JSONObject>> futures = new ArrayList<Future<JSONObject>>();
//        List<ThreadHandlerRequest> list = new ArrayList<ThreadHandlerRequest>();
        List<ThreadHandlerRequestOne> list = new ArrayList<ThreadHandlerRequestOne>();


        /*
        * 少开几个线程，每个线程多一些处理
        *
        * */
        //        int threaSize = 1;
//        int threaSize = (result.size() / 10)+1;
//        for(int i =0; i <= 10; i++) {
////            JSONObject singleobje=result.getJSONObject(i);
//            JSONArray manyUrl = new JSONArray();
//            while (result.size()>0){
//                if(manyUrl.size() == threaSize)
//                    break;
//                manyUrl.add( result.remove( 0 ) );
//            }
////            System.out.println(manyUrl.size()+"@#￥ "+manyUrl);
//            list.add(new ThreadHandlerRequest(manyUrl,time));
//        }
        int j=10;int a=1;
        if (result.size()<=100){a=4;}
        else if(100<result.size()&&result.size()<=150){a=3;}
        else if(150<result.size()&&result.size()<=250){a=2;}

        for (int i=0;i<result.size();i++){
            JSONObject singleobje=result.getJSONObject(i);
            //每10个减a级
            if(i%10==0){ j=j-a; }
            if(j<1){ j=10; }

            ThreadHandlerRequestOne one = new ThreadHandlerRequestOne( singleobje, time,j);
            list.add(one);

        }

//        //下面这个逻辑，保证异步任务都可以完成。并且保存上一个异步任务执行的结果
//        for (int i =0; i < result.size(); i++) {
//
//            JSONObject singleobje=result.getJSONObject(i);
//            //申请单个线程执行类
//            ThreadHandlerRequest call =new ThreadHandlerRequest(singleobje);
////            try {
//////                JSONObject data = call.call();
//////                System.out.println("@#$ "+data);
//////            } catch (Exception e) {
//////                e.printStackTrace();
//////            }
//            //提交单个线程
//            Future< JSONObject> future = execPool.submit(call);
//            //将每个线程放入线程集合， 这里如果任何一个线程的执行结果没有回调，线程都会自动堵塞
//            futures.add(future);
//
//        }
        System.out.println("主线程发起异步任务请求");
        long startTime = System.currentTimeMillis();
        List<Future<GuiJi>> futures2 = execPool.invokeAll(list);
        System.out.println("22调用API耗时 : " + (System.currentTimeMillis() - startTime) );
        List<GuiJi> guiJiList = new ArrayList<>();
        for(Future<GuiJi> future : futures2) {
            try {
//                guiJiList.addAll( future.get() );
//                JSONObject json = future.get();
//                System.out.println("--------------------------------" + json);
                //业务逻辑
//                GuiJi guiji = getGuijiJingWeiDu( json, time );
                GuiJi guiji = future.get();
                if(guiji.getJindu()!=null&&!("null".equals(String.valueOf( guiji.getJindu() )))) {
                    guiji.setUserId( PACHONG_ADMINID );
                    guiJiList.add( guiji );
                }
//                guiJiList.add( guiji );

            } catch (Exception e) {
//                log.error("remote Api failed ： {}", e.getCause().getMessage());
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("线程耗时 : " + (endTime - startTime) );
        //关闭线程池
        execPool.shutdown();

        return guiJiList;
    }

    public static List<GuiJi> addGuijiListOnThrea(JSONArray r,ArrayList<String> timeList,ArrayList<Long> orderIdList) throws InterruptedException {
        //组合线程请求参数
        JSONArray result = r;
        if(r.size()==0){
            System.out.println(r+" "+result.size());
            return null;
        }
        ExecutorService execPool = Executors.newFixedThreadPool(result.size());
//        List<Future<JSONObject>> futures = new ArrayList<Future<JSONObject>>();
//        List<ThreadHandlerRequest> list = new ArrayList<ThreadHandlerRequest>();
        List<ThreadAddOneGuiji> list = new ArrayList<ThreadAddOneGuiji>();

        int j=10;int a=1;
        if (result.size()<=100){a=4;}
        else if(100<result.size()&&result.size()<=150){a=3;}
        else if(150<result.size()&&result.size()<=250){a=2;}


        for (int i=0;i<result.size();i++){
//            JSONObject singleobje=result.getJSONObject(i);
            //每10个减a级
            if(i%10==0){ j=j-a; }
            if(j<1){ j=10; }
                ThreadAddOneGuiji one = new ThreadAddOneGuiji( result.getJSONObject(i), timeList.get( i ), j, orderIdList.get( i ) );
                list.add(one);
        }

        System.out.println(result.size()+"个线程 主线程发起异步任务请求，策略是"+a);
        long startTime = System.currentTimeMillis();
        List<Future<GuiJi>> futures2 = execPool.invokeAll(list);
        System.out.println("22调用API耗时 : " + (System.currentTimeMillis() - startTime) );
        List<GuiJi> guiJiList = new ArrayList<>();
        for(Future<GuiJi> future : futures2) {
            try {
//                guiJiList.addAll( future.get() );
//                JSONObject json = future.get();
//                System.out.println("--------------------------------" + json);
                //业务逻辑
//                GuiJi guiji = getGuijiJingWeiDu( json, time );
                GuiJi guiji = future.get();
                if (guiji==null||"null".equals( guiji )){
                    continue;
                }
                if(guiji.getJindu()!=null&&!("null".equals(String.valueOf( guiji.getJindu() )))) {
//                    guiji.setUserId( PACHONG_ADMINID );
//                    guiji.setArea( YNDhmNewDateString() );
//                    guiji.setOrderId( orderId );
                    guiJiList.add( guiji );
                }
//                guiJiList.add( guiji );

            } catch (Exception e) {
//                log.error("remote Api failed ： {}", e.getCause().getMessage());
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("线程耗时 : " + (endTime - startTime) );
        //关闭线程池
        execPool.shutdown();

        return guiJiList;
    }

    public static void main(String[] args) throws InterruptedException {
        futureUtil con = new futureUtil();
//        con.getGuijiListOnThrea();
    }
}
