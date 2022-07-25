package com.kangyi.util;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringTest2 {
    private static String StringChange(String str) throws Exception {
        if(str==null||str.length()==0){throw new Exception("解析字串为空!");}//判空
        /**
         * 创建结果集合
         */
        ArrayList<String> dataString = new ArrayList<>();//日期集合
        ArrayList<String> finalString = new ArrayList<>();//结果集

        boolean flag = checkDataStr(str); //比较日期与开始日期是否一致（长度）

        String s = str.substring(str.indexOf("】")+1);
        Pattern p = Pattern.compile("((\\d{1,2})月(\\d{1,2})日\\-(\\d{1,2})日)|((\\d{1,2})月(\\d{1,2})日)");
        Matcher m = p.matcher(s);

        while(m.find()){
            //按照日期进行匹配并转换为fuck
            s = s.replace(m.group(),"fuck");
            s = s.replace("，","");
            dataString.add(m.group());//加入日期集合
        }
        String[] v = s.split("fuck");
        int index = 0;
//        if(!flag){
            //日期与开始日期一致（长度）
            Pattern p1 = Pattern.compile("(((.{1,2}?省)(.*?市)(.*?县))|((.{1,2}?区))|((.*?宾馆))|((.*?医院)))");//拆分格式
            for(String st:v){
                if(st.length()!=0){
                    Matcher m1 = p1.matcher(st);//matcher方法进行格式匹配
                    if (m1.find()){
                        //匹配到的按拆分值加入
                        finalString.add(dataString.get(index++)+":"+m1.group(0));
                    }else {
                        //匹配不到直接加
                        finalString.add(dataString.get(index++)+":"+st);
                    }
                }
            }
//        }else {
            //日期与开始日期不一致（长度）
//            for(String st:v){
                //直接拆分写入
//                if(st.length()!=0){
//                    finalString.add(dataString.get(index++)+":"+st);
//                }
//            }
//        }
     return JSONArray.toJSONString(finalString);
    }
    private static boolean checkDataStr(String str){
        String data = str.substring(str.indexOf("【")+1,str.indexOf("】"));
        str = str.substring(str.indexOf("】")+1);
        String anData = str.substring(str.indexOf("】")+1,str.indexOf("日")+1);
       return (data.length()==anData.length());
    }
/*
* 判断有无到、在、去等字
* */
//    public static String ifCity(String s){
//        String city=null;
//        boolean a = s.contains( "到" )||s.contains( "在" )||s.contains( "去" );
//        if (a){
////            city=s;
//            s.split( "到" )
//        }else {
//            city=s+"市";
//        }
//        return city;
//    }

    public static void main(String[] args) throws Exception{
//        String str = "【3月23日】3月8日-13日每天早晨到海港区东方明珠城骑自行车，3月8日-13日骑车到达开发区日九冷库，3月8日-13日再驾车到唐山路北区盛华农贸市场，3月8日-13日再驾车到唐山路北区君瑞市场，3月14日居家无外出，3月15日-17日早晨到海港区东方明珠城骑自行车，3月15日-17日到达开发区日九冷库，3月15日-17日驾车到唐山路北区盛华农贸市场，3月15日-17日驾车到唐山路北区君瑞市场，3月18日-19日程居家，无外出，3月20日到第三医院采样测核酸为阴性，3月21日居家，无外出，3月21日23时04分被转运到夏都宾馆隔离点集中隔离观察，3月22日其核酸检测结果异常，3月22日下午6时20分海港区疾控中心初筛阳性，3月23日凌晨0时30分，秦皇岛市疾控中心复核阳性，3月23日经专家会诊诊断为新冠肺炎轻型病例，目前在秦皇岛市第三医院隔离治疗";
        String str = "【3月29日】3月19日受单位派遣，前往吉林省长春市参与方舱医院建设，3月19日13时12分乘坐G2633次高铁，3月19日16时58分抵达长春西站，3月19日后前往当地住宿地壹号公寓入住，3月20日-24日每天早晨7时左右乘坐大巴车抵达方舱医院工地，3月20日-24日晚上收工后返回壹号公寓，3月20日-24日每日三餐均在方舱医院工地和壹号公寓就餐，3月25日晚23时5分集体乘坐K568次列车返回，3月26日早晨8时34分抵达山海关站，3月26日后集体入住山海关帝森酒店，3月27日由负压救护车转运到山海关祥英宾馆集中隔离，3月29日诊断为新冠肺炎确诊病例";
//        String str = "【3月29日】3月19日受单位派遣，前往吉林省长春市参与方舱医院建设，3月19日13时12分乘坐G2633次高铁，3月19日16时58分抵达长春西站，3月19日后前往当地住宿地壹号公寓入住，3月20日-24日每天早晨7时左右乘坐大巴车抵达方舱医院工地，3月20日-24日晚上收工后返回壹号公寓，3月20日-24日每日三餐均在方舱医院工地和壹号公寓就餐，3月25日晚23时5分集体乘坐K568次列车返回，3月26日早晨8时34分抵达山海关站，3月26日后集体入住山海关帝森酒店，3月27日由负压救护车转运到山海关祥英宾馆集中隔离，3月29日诊断为新冠肺炎确诊病例";

//        String str = "【4月30日】4月30日白云区龙归街道北村4月30日小渔寿司(人和西街店)4月30日白云区人和镇凤和村4月30日人和镇第八小学4月30日林记烧腊快餐店(第二分店)4月30日白云区鹤龙街道鹤边村4月30日鸿缘堂4月30日增城区荔城街道廖隔塘村4月30日白云区人和镇矮岗村4月30日花都区狮岭镇金碧御水山庄4月30日花都区花东镇联安村4月30日白云区新市街道棠涌村4月30日白云区人和镇鸦湖村4月30日白云区人和镇西成村4月30日茶理宜世(人和店)4月30日全饰美精品屋4月30日家园甜品4月30日达安驾校(西成路)4月30日领鲜荟生鲜批发零售市场4月30日鲜果特卖场4月30日鹤南综合市场4月30日熙镓便利店4月30日白云区人和镇大巷村4月30日白云区人和镇高增村4月30日白云区人和镇东华村4月30日顺景路湘缘百货4月30日威特思面包店4月30日乐卖特连锁超市(YH城店)4月30日情轩花店4月30日新港百货4月30日白云区人和镇新联村4月30日白云区人和镇人和村4月30日大川药房";
        String s = StringChange(str);
        System.out.println(s);
    }
}
