package com.kangyi.util;

import com.kangyi.pojo.GuiJi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.kangyi.util.GuijiJingWeiDU.getGuijiJingWeiDu;

public class ThreadHandlerRequestOne implements Callable<GuiJi> {
    private JSONObject requestParams;
    private String time;
    private int priority;

    public ThreadHandlerRequestOne(JSONObject paramter, String time,int Priority) {
        this.requestParams = paramter;
        this.time = time;
        this.priority = Priority;

    }
    public ThreadHandlerRequestOne(JSONObject paramter, String time) {
        this.requestParams = paramter;
        this.time = time;

    }


    @Override
    public GuiJi call() throws Exception {
        // TODO Auto-generated method stub
        Thread.currentThread().setPriority( this.priority );

        GuiJi guiji = new GuiJi();

//            String htmlJson = null;
            try {

//                String htmlJson = HttpRemoteUtil.getHttpRequest( this.requestParams.getString( "requestUrl" ) );
                String htmlJson = HttpURLConnectionUtil.doGet( this.requestParams.getString( "requestUrl" ) );
//                Thread.sleep(5);
                int i=1;
                JSONObject jsonObject = JSONObject.fromObject( htmlJson );
                while (!"0".equals(  jsonObject.getString( "status" ))){
//                System.out.println("@#$ThreadHandlerRequest                                       "+htmlJson);
                Thread.sleep(50+i*20);
                htmlJson = HttpURLConnectionUtil.doGet(this.requestParams.getString("requestUrl"));
                 jsonObject = JSONObject.fromObject( htmlJson );
            }

//                JSONObject res = JSONObject.fromObject( htmlJson );
                guiji = getGuijiJingWeiDu( jsonObject, time );




            } catch (Exception e) {
                // TODO: handle exception
            }

        return guiji;
//        return JSONObject.fromObject( htmlJson );
    }

}
