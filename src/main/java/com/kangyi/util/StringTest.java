package com.kangyi.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringTest {
    public static Map<String, String> oldStringChange(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception( "解析字串为空!" );
        }
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>( 3 );

        StringBuffer stringBuffer = new StringBuffer( str );
        String TempStr = stringBuffer.substring( 1, stringBuffer.indexOf( "】" ) );
        str = stringBuffer.substring( stringBuffer.indexOf( "】" ) + 1 );
        String[] values = str.split( TempStr );
        for (String s : values) {
            if (s.length() != 0) {
                list.add( s + ":" + TempStr );
                map.put( s, TempStr );
            }
        }
//        return JSONArray.toJSONString(list);
        return map;
    }

    public static String StringChangeJSON(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception( "解析字串为空!" );
        }//判空
        if(!str.contains( "【" )) {
            throw new Exception( str+"少了中括号!" );
        }

        /**
         * 创建结果集合
         */
        ArrayList<String> dataString = new ArrayList<>();//日期集合
        ArrayList<String> finalString = new ArrayList<>();//结果集
        Map<String, String> map = new HashMap<>( 3 );

        boolean flag = checkDataStr( str ); //比较日期与开始日期是否一致（长度）

        String s = str.substring( str.indexOf( "】" ) + 1 );
        Pattern p = Pattern.compile( "((\\d{1,2})月(\\d{1,2})日\\-(\\d{1,2})日)|((\\d{1,2})月(\\d{1,2})日)" );
        Matcher m = p.matcher( s );

        while (m.find()) {
            //按照日期进行匹配并转换为fuck
            s = s.replace( m.group(), "fuck" );
            s = s.replace( "，", "" );
            dataString.add( m.group() );//加入日期集合
        }
        String[] v = s.split( "fuck" );
        int index = 0;
        if(!flag){
//            System.out.println("nn");
            //日期与开始日期不一致（长度）
            Pattern p1 = Pattern.compile( "((.*?县))|((.*?市))|((.{1,2}?区))|((.{1,2}?服务区))|((.*?宾馆))|((.*?医院))|((.*?公寓))|((.*?超市))|((.*?城))|((.*?镇))|((.*?街))" );//拆分格式
            for (String st : v) {
                if (st.length() != 0) {
                    Matcher m1 = p1.matcher( st );//matcher方法进行格式匹配
                    if (m1.find()) {
                        //匹配到的按拆分值加入
//                    finalString.add( dataString.get( index++ ) + ":" + m1.group( 0 ) );
                        map.put( m1.group( 0 ) , dataString.get( index++ ));
                    } else {
                        //匹配不到直接加
//                    finalString.add( dataString.get( index++ ) + ":" + st );
                        map.put( st,dataString.get( index++ ) );
                    }
                }
            }
        }else {
//            System.out.println("yy");
//        日期与开始日期一致（长度）
            for(String st:v){
//        直接拆分写入
                if(st.length()!=0){
//                    finalString.add(dataString.get(index++)+":"+st);
                    map.put( st,dataString.get( index++ ) );
                }
            }
        }
        return JSONArray.toJSONString(map);
    }



    public static Map<String,String> StringChange(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception( "解析字串为空!" );
        }//判空
        if(!str.contains( "【" )) {
            throw new Exception( str+"少了中括号!" );
        }

        /**
         * 创建结果集合
         */
        ArrayList<String> dataString = new ArrayList<>();//日期集合
        ArrayList<String> finalString = new ArrayList<>();//结果集
        Map<String, String> map = new HashMap<>( 3 );

        boolean flag = checkDataStr( str ); //比较日期与开始日期是否一致（长度）

        String s = str.substring( str.indexOf( "】" ) + 1 );
        Pattern p = Pattern.compile( "((\\d{1,2})月(\\d{1,2})日\\-(\\d{1,2})日)|((\\d{1,2})月(\\d{1,2})日)" );
        Matcher m = p.matcher( s );

        while (m.find()) {
            //按照日期进行匹配并转换为fuck
            s = s.replace( m.group(), "fuck" );
            s = s.replace( "，", "" );
            dataString.add( m.group() );//加入日期集合
        }
        String[] v = s.split( "fuck" );
        int index = 0;
        if(!flag){
//            System.out.println("nn");
        //日期与开始日期不一致（长度）
        Pattern p1 = Pattern.compile( "((.*?县))|((.*?市))|((.{1,2}?区))|((.{1,2}?服务区))|((.*?宾馆))|((.*?医院))|((.*?公寓))|((.*?超市))|((.*?城))|((.*?镇))|((.*?街))" );//拆分格式
        for (String st : v) {
            if (st.length() != 0) {
                Matcher m1 = p1.matcher( st );//matcher方法进行格式匹配
                if (m1.find()) {
//                if (m1.find()&&m1.group( 0 ).trim().length()>0) {
                    //匹配到的按拆分值加入
//                    finalString.add( dataString.get( index++ ) + ":" + m1.group( 0 ) );
                    String group = m1.group( 0 );
                    String s1 = dataString.get( index++ );
                    map.put( group , s1);
//                    map.put( m1.group( 0 ) , dataString.get( index++ ));
                } else {
                    //匹配不到直接加
//                    finalString.add( dataString.get( index++ ) + ":" + st );
                    map.put( st,dataString.get( index++ ) );
                }
            }
        }
        }else {
//            System.out.println("yy");
//        日期与开始日期一致（长度）
            for(String st:v){
//        直接拆分写入
                if(st.length()!=0){
//                    finalString.add(dataString.get(index++)+":"+st);
                    map.put( st,dataString.get( index++ ) );
                }
            }
        }
        return map;
    }

    private static boolean checkDataStr(String str){
//        System.out.println(str.length()+"  str "+str);
            String data = str.substring( str.indexOf( "【" ) + 1, str.indexOf( "】" ) );
            str = str.substring( str.indexOf( "】" ) + 1 );
            String anData = str.substring( str.indexOf( "】" ) + 1, str.indexOf( "日" ) + 1 );
//        System.out.println(data +" d s "+anData);
            return (data.equals( anData ));

    }



    public static String ifCity(String s){
        String city=null;
        boolean a = s.contains( "市" );
        if (a){
            city=s;
        }else {
            city=s+"市";
        }
        return city;
    }

    public static boolean isJsonObject(String content) {
        // 此处应该注意，不要使用StringUtils.isEmpty(),因为当content为"  "空格字符串时，JSONObject.parseObject可以解析成功，
        // 实际上，这是没有什么意义的。所以content应该是非空白字符串且不为空，判断是否是JSON数组也是相同的情况。
        if(StringUtils.isBlank(content))
            return false;
        try {
            JSONObject jsonStr = JSONObject.parseObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public static void main(String[] args) throws Exception{
//        String str = "【3月24日】3月23日上午10时左右从辽宁省朝阳市凌源市装蔬菜（黄瓜），3月23日中午12时左右出发，前往目的地石家庄市，3月23日中途接到凌源市电话通知，核酸检测结果异常，要求就近停靠，3月23日晚22时38分驶入京港澳高速定州服务区，停靠在大型车辆停车区内，期间未下车，3月24日凌晨1时28分采集咽拭子，早7时32分实验室报告结果为阳性，现已转运至保定市定点救治医院，诊断为新冠确诊病例";
                String str = "【1月18日】1月17日居住地为东昌区和平新园后老一楼，1月18日经专家组会诊，订正为确诊病例，临床分型为普通型";
//                String str = "【3月29日】3月19日受单位派遣，前往吉林省长春市参与方舱医院建设，3月19日13时12分乘坐G2633次高铁，3月19日16时58分抵达长春西站，3月19日后前往当地住宿地壹号公寓入住，3月20日-24日每天早晨7时左右乘坐大巴车抵达方舱医院工地，3月20日-24日晚上收工后返回壹号公寓，3月20日-24日每日三餐均在方舱医院工地和壹号公寓就餐，3月25日晚23时5分集体乘坐K568次列车返回，3月26日早晨8时34分抵达山海关站，3月26日后集体入住山海关帝森酒店，3月27日由负压救护车转运到山海关祥英宾馆集中隔离，3月29日诊断为新冠肺炎确诊病例";
//        String str = "【4月30日】4月30日白云区龙归街道北村4月30日小渔寿司(人和西街店)4月30日白云区人和镇凤和村4月30日人和镇第八小学4月30日林记烧腊快餐店(第二分店)4月30日白云区鹤龙街道鹤边村4月30日鸿缘堂4月30日增城区荔城街道廖隔塘村4月30日白云区人和镇矮岗村4月30日花都区狮岭镇金碧御水山庄4月30日花都区花东镇联安村4月30日白云区新市街道棠涌村4月30日白云区人和镇鸦湖村4月30日白云区人和镇西成村4月30日茶理宜世(人和店)4月30日全饰美精品屋4月30日家园甜品4月30日达安驾校(西成路)4月30日领鲜荟生鲜批发零售市场4月30日鲜果特卖场4月30日鹤南综合市场4月30日熙镓便利店4月30日白云区人和镇大巷村4月30日白云区人和镇高增村4月30日白云区人和镇东华村4月30日顺景路湘缘百货4月30日威特思面包店4月30日乐卖特连锁超市(YH城店)4月30日情轩花店4月30日新港百货4月30日白云区人和镇新联村4月30日白云区人和镇人和村4月30日大川药房";

//        Map<String, String> s = StringChange( str );
        String city = ifCity( "宁波" );
        String city2 = ifCity( "广州市" );
        String city3 = ifCity( "哈尔滨" );
        Map<String, String> s = StringChange( str );
        System.out.println(s);
//        System.out.println(city+city2+city3);
    }
}
