package com.kangyi.util;

import com.kangyi.pojo.GuiJi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.kangyi.util.GuijiJingWeiDU.getGuijiJingWeiDu;

public class ThreadHandlerRequest  implements Callable<List<GuiJi>> {
    private JSONObject requestParams;
    private JSONArray manyUrl;
    private String time;

    public ThreadHandlerRequest(JSONObject paramter) {
        this.requestParams = paramter;
    }
    public ThreadHandlerRequest(JSONArray ManyUrl,String time) {
        this.time = time;
        this.manyUrl=ManyUrl;
    }

    @Override
    public List<GuiJi> call() throws Exception {
        // TODO Auto-generated method stub
        List<GuiJi> guiJiList = new ArrayList<>();
//        JSONArray ress=null;
        for (int i=0;i<this.manyUrl.size();i++) {
            this.requestParams = manyUrl.getJSONObject( i );

//            String htmlJson = null;
            try {
                String htmlJson = HttpRemoteUtil.getHttpRequest( this.requestParams.getString( "requestUrl" ) );
//                Thread.sleep(10);
                JSONObject jsonObject = JSONObject.fromObject( htmlJson );
                while (!"0".equals(  jsonObject.getString( "status" ))){
//                System.out.println("@#$ThreadHandlerRequest                                       "+htmlJson);
                Thread.sleep(5);
                htmlJson = HttpRemoteUtil.getHttpRequest(this.requestParams.getString("requestUrl"));
                 jsonObject = JSONObject.fromObject( htmlJson );
            }

                JSONObject res = JSONObject.fromObject( htmlJson );
                GuiJi guiji = getGuijiJingWeiDu( res, time );
                if(guiji.getJindu()!=null&&!("null".equals(String.valueOf( guiji.getJindu() )))) {
                    guiJiList.add( guiji );
                }

//                ress.add( res );

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return guiJiList;
//        return JSONObject.fromObject( htmlJson );
    }

}
