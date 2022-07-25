package com.kangyi.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpRemoteUtil {
    public static String getHttpRequest(String url) throws IOException {
        //创建一个HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpPost post = new HttpPost(url);
        HttpGet get = new HttpGet(url);
        String jsonString=null;
        //这个list用于存放自己要传递的参数，比如说一些认证信息，你懂得。
//		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//		UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            //把需要传递的参数交给这个entity
//			urlEncodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
            //将实体放入http请求中
//			post.setEntity(urlEncodedFormEntity);
            CloseableHttpResponse response = httpClient.execute(get);
            //这个返回值其实就是验证一下，请求是否成功，如果是200的话
            int statusCode = response.getStatusLine().getStatusCode();//获取返回的状态值
            HttpEntity entity = response.getEntity();
            jsonString = EntityUtils.toString(entity, "UTF-8");
//			JSONObject result = JSONObject.parseObject(jsonString);
            return jsonString;
        } catch (Exception e) {
//            log.error("[service-synchronizeData]--- error ---, [Exception]= " + e.toString() + "");
        } finally {
            httpClient.close();
        }
        return jsonString;
    }

    public static void main(String[] args) {
        try {
            String guijiurl1="https://m.sm.cn/api/rest?format=json&from=&method=Maskbuy.areaData&prov=广东省&city=广州市";

            String result =  getHttpRequest(guijiurl1);
            System.out.println("@#$11     "+result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
