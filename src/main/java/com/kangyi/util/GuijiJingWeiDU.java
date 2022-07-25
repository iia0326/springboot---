package com.kangyi.util;

import com.kangyi.pojo.GuiJi;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.kangyi.util.StringToDate.YRDateString;
import static com.kangyi.util.StringToDate.dateAddTian;

public class GuijiJingWeiDU {
    public static GuiJi getGuijiJingWeiDu(JSONObject json_jingwei,String time) {
//        List<GuiJi> guiJiList = new ArrayList<>();
        GuiJi guiJi = new GuiJi();
        String message = json_jingwei.getString( "message" );
        if ("query ok".equals( message )) {

            JSONObject json_result = json_jingwei.getJSONObject( "result" );
            JSONObject json_location= json_result.getJSONObject( "location" );
            JSONObject json_address_components = json_result.getJSONObject( "address_components" );
            String city = json_address_components.getString( "city" );

            guiJi.setJindu( new BigDecimal( json_location.getString( "lng" ) ) );
            guiJi.setWeidu( new BigDecimal( json_location.getString( "lat" ) ) );
            guiJi.setGuijiPosition( city + json_result.getString( "title" ) );
            guiJi.setStarttime( YRDateString( time, "00:00" ) );
            guiJi.setEndtime( YRDateString( time, "23:59" ) );
            guiJi.setEnddate( dateAddTian( guiJi.getEndtime(), 30 ) );
//                       guiJi.setEndtime(  );
//                       System.out.println("@#$!!"+guiJi);
//            guiJiList.add( guiJi );


        }
        return guiJi;
    }
    public static void main(String[] args) {

    }
}
