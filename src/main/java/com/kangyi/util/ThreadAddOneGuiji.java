package com.kangyi.util;

import com.kangyi.pojo.GuiJi;
import net.sf.json.JSONObject;

import java.util.concurrent.Callable;

import static com.kangyi.constant.Constant.PACHONG_ADMINID;
import static com.kangyi.util.GuijiJingWeiDU.getGuijiJingWeiDu;
import static com.kangyi.util.StringToDate.YNDhmNewDateString;

public class ThreadAddOneGuiji implements Callable<GuiJi> {
    private JSONObject requestParams;
    private String time;
    private int priority;
    private Long orderId;

    public ThreadAddOneGuiji(JSONObject paramter, String time, int Priority,Long orderId) {
        this.requestParams = paramter;
        this.time = time;
        this.priority = Priority;
        this.orderId=orderId;

    }
    public ThreadAddOneGuiji(JSONObject paramter, String time) {
        this.requestParams = paramter;
        this.time = time;

    }


    @Override
    public GuiJi call() throws Exception {
        // TODO Auto-generated method stub
        if (this.priority>0){
        Thread.currentThread().setPriority( this.priority );
        }
        GuiJi guiji = new GuiJi();
            try {
                String htmlJson = HttpURLConnectionUtil.doGet( this.requestParams.getString( "requestUrl" ) );
//                Thread.sleep(5);
                int i=1;
                JSONObject jsonObject = JSONObject.fromObject( htmlJson );
//                while (!"0".equals(  jsonObject.getString( "status" ))) {
                    if ("347".equals( jsonObject.getString( "status" ) )) {
                        System.out.println( jsonObject.toString()+"@#$$ThreadHandlerRequest    " + this.requestParams.getString( "requestUrl" ) );
//                        break;
                    }
                    if ("348".equals( jsonObject.getString( "status" ) )) {
                        System.out.println( jsonObject.toString()+"@#$$ThreadHandlerRequest    " + this.requestParams.getString( "requestUrl" ) );
//                        break;
                    }
//                }
                    while ("120".equals(  jsonObject.getString( "status" ))){
//                System.out.println("@#$ThreadHandlerRequest                                       "+htmlJson);
                        if (i > 20) {
                            break;
                        }
                Thread.sleep(200+i*50);
                htmlJson = HttpURLConnectionUtil.doGet(this.requestParams.getString("requestUrl"));
                 jsonObject = JSONObject.fromObject( htmlJson );
            }

                if ("0".equals( jsonObject.getString( "status" ) )) {
//                JSONObject res = JSONObject.fromObject( htmlJson );
                    guiji = getGuijiJingWeiDu( jsonObject, time );

                    if (guiji.getJindu() != null) {
                        guiji.setUserId( PACHONG_ADMINID );
                        guiji.setOrderId( orderId );
                        guiji.setArea( YNDhmNewDateString() );
                    }
                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        return guiji;
//        return JSONObject.fromObject( htmlJson );
    }

}
