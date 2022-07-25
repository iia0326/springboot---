package com.kangyi.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ManyUrlKeyUtil {

    static String url="https://apis.map.qq.com/ws/geocoder/v1/?key=";

    static String a="FT6BZ-GPELV-OJHPG-UPJO2-VHCCZ-62BKL";
    static String b="DVIBZ-XMKE6-6TSSY-M6U7B-OYUJE-INBVY";
    static String c="JYXBZ-3C5CJ-UBRF6-FOPY3-L546H-2BFIS";
    static String d="UO6BZ-3B26S-2OBO5-6B6YA-YDTTJ-HJBKN";
    static String e="SH3BZ-ZFFCS-ZDROC-6OXRD-XUKZT-34BLJ";
    static String f="URBBZ-ZUKY6-IZGSH-M57EF-KKHJQ-CBFSL";
    static String g="GSABZ-AGLLS-CO3OG-67YT3-AS3TZ-U6B6Z";
    static String h="2UHBZ-KDTLS-ADKOP-6RCCO-IU6Z7-HQFOJ";
    static String ii="DC2BZ-NRBC3-VIZ35-YSAXX-J4VQ5-ACFM5";
    static  String jj="66BBZ-HAIK4-RSQUK-XPY2Q-XUFMH-YJFXF";

    static String address="&address=";


    public static String getUrl(int i){
        url="https://apis.map.qq.com/ws/geocoder/v1/?key=";
        int j = i % 10;
        if(j==1){
            url=url+a+address;
        }else if(j==2){
            url=url+b+address;
        }else if(j==3){
            url=url+d+address;
        }else if(j==4){
            url=url+e+address;
        }else if(j==5){
            url=url+f+address;
        }else if(j==6){
            url=url+g+address;
        }else if(j==7){
            url=url+h+address;
        }else if(j==8){
            url=url+ii+address;
        }else if(j==9){
            url=url+jj+address;
        }else  {
            url=url+c+address;
        }
        return url;
    }
    public static String getUrl(){
    Set<String> set = new HashSet<String>();
        set.add(url+a+address); set.add(url+b+address); set.add(url+c+address); set.add(url+d+address);
        set.add(url+e+address); set.add(url+f+address); set.add(url+g+address); set.add(url+h+address);
        set.add(url+ii+address);
        set.add(url+jj+address);

    ArrayList<String> list = new ArrayList(set);
    int randomIndex1 = new Random().nextInt(list.size());
    int randomIndex2 = new Random().nextInt(list.size());
    String randomItem = list.get((randomIndex1+randomIndex2)>>1);
        return randomItem;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            System.out.println(getUrl());
        }
    }
}
