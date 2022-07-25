package com.kangyi.quartz;

//import org.apache.shiro.authc.Account;

//import com.kangyi.mapper.GuiJi123Mapper;
import com.kangyi.mapper.GuiJiMapper;
import com.kangyi.mapper.OrderMapper;
import com.kangyi.pojo.GuiJi;
import com.kangyi.pojo.Order;
import com.kangyi.service.OrderService;
import com.kangyi.util.GetListGuiji;
import com.kangyi.util.HttpURLConnectionUtil;
import com.kangyi.util.jsoup.JsoupUtil;
import net.sf.json.JSONObject;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.kangyi.constant.Constant.PACHONG_ADMINID;
//import static com.kangyi.util.GetListGuiji.addListGuiji;
import static com.kangyi.util.GetListGuiji.getListGuiji;
import static com.kangyi.util.StringTest.isJsonObject;

public class GuijiQuartz extends QuartzJobBean {

    @Autowired
    GuiJiMapper guiJiMapper;
    @Autowired
    OrderService orderService;
    @Autowired
    GetListGuiji getListGuiji;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//
        //TODO 这里写定时任务的执行逻辑
        System.out.println( "动态的定时任务执行时间：" + new Date().toLocaleString() );
////        List<GuiJi> guiJiList = new ArrayList<>();
        String guijiurl = "https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData";
        long startTime1 = System.currentTimeMillis();
        String s = JsoupUtil.JsoupGetData( guijiurl );
//        String s = HttpURLConnectionUtil.doGet( guijiurl );
//        String s = HttpClientUtil.doGet( guijiurl );
//        String s = HttpRemoteUtil.getHttpRequest( guijiurl );
        System.out.println( "定时任务调用guijiurl耗时 : " + (System.currentTimeMillis() - startTime1) );
        if (!isJsonObject(s)){
            System.out.println("解析guijiurl失败，无内容");
            return;
        }
        JSONObject json_s = JSONObject.fromObject( s );
        JSONObject json_data = json_s.getJSONObject( "data" );
        if (!"null".equals( json_data.toString() ) && json_data != null) {
//        JSONObject json_data = JSONObject.fromObject(data);
            Integer totalPage = json_data.getInt( "totalPage" );
            if (totalPage != null) {
                for(int i=1;i<=totalPage;i++){
                    try {
                        long startTime2 = System.currentTimeMillis();
                        List<GuiJi> listGuiji = getListGuiji.addListGuiji( i );
//                        List<GuiJi> listGuiji = addListGuiji( i ,orderId);
//                        guiJiMapper.insertList(listGuiji);
                        System.out.println( i+" :"+totalPage+"@加入一页耗时 : " + (System.currentTimeMillis() - startTime2) );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
              }
            }
        System.out.println( "@总耗时 : " + (System.currentTimeMillis() - startTime1) );



        }

    }