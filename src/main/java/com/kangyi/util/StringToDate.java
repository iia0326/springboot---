package com.kangyi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StringToDate {
    static public Date YMDToDate(String a){
        System.out.println("@@stringToDate "+a);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if(a.trim().length()>0||a!=null){

            try {
                date = sdf.parse(a);
            } catch (ParseException e) {
                date = null;
                System.out.println("@#$ "+a+" 日期空的");

            }
        }
        return date;
    }

    static public Date YMDmsToDate(String a){
        System.out.println("@@stringToDate "+a);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        if(a.trim().length()>0||a!=null){

            try {
                date = sdf.parse(a);
            } catch (ParseException e) {
                date = null;
                System.out.println("@#$ "+a+" 日期空的");
            }
        }
        return date;
    }

    static public Date YMDmToDate(String a){
        System.out.println("@@stringToDate "+a);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        if(a.trim().length()>0||a!=null){

            try {
                date = sdf.parse(a);
            } catch (ParseException e) {
                date = null;
                System.out.println("@#$ "+a+" 日期空的");
            }
        }
        return date;
    }

    static public Date dateAddTian(Date d, int t){

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, t);
        Date date =cal.getTime();
        return date;
    }



    static public String YNDhmNewDateString(){

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date =formatter.format( new Date() );
        return date;
    }


    static public Date YRDateString(String a,String b){
        StringBuffer stringBuffer = new StringBuffer(a);
        String TempStr = stringBuffer.substring(0,stringBuffer.indexOf("日"));
        String[] values = TempStr.split("月");
        String m = values[0];
        String r = values[1];
        Date dt=new Date();
        String y= String.valueOf( dt.getYear()+1900 );
        String str=y+"-"+m+"-"+r+" "+b;
//        System.out.println("@#$ "+str );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        if(a.trim().length()>0||a!=null){

            try {
                date = sdf.parse(str);
//                System.out.println("@#$ "+date );
            } catch (ParseException e) {
                date = null;
                System.out.println("@#$ "+a+" 日期空的");
            }
        }
        return date;
    }

    public static void main(String[] args) {
//        String a="6月3日";
//        String a="3月20日-24日";
//        String b="11月23日";
//        String c="5月1日";
//        String e="12月3日";
//        System.out.println(YRDateString(a,"00:00")+"  "+YRDateString(b,"23:00")+"  "+YRDateString(c,"00:56")+"  "+YRDateString(e,"00:00")+"  ");
        Date date = dateAddTian( new Date(), -3 );
        System.out.println(date);

    }

}
