package com.kangyi.util.jsoup;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupUtil {
    public static String JsoupGetData(String url){
        Object res = "";
        try {
            Document doc = Jsoup.connect(url)
//            Document doc = Jsoup.connect("https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&page=1")
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)")
                    .header("content-type", "application/json")
                    .timeout(50000).get();
            res = JSONUtil.parseObj(doc.body().html());
//            res = JSONUtil.parseObj(doc.body().html()).get("data");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println( "@#$1  "+ResultGenerator.genSuccessResult( JSON.parse(res.toString())));
        return res.toString();
//        return JSON.parse(res.toString());
    }
}
