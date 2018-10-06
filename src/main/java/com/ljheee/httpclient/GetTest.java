package com.ljheee.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * httpClient get请求
 */
public class GetTest {
    public static void main(String[] args) throws IOException {

//        发起一个http请求:
//        1:客户端(浏览器、fiddler、手机(设置代理)、postman) --》http客户端、发包的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        2:请求的地址: url
        String url = "https://postman-echo.com/get?test=123";
//        3:创建一个get请求
        HttpGet get = new HttpGet(url);
//        5:请求头:附带信息描述,请求提交内容格式、想要获得内容格式
//        6:请求体:提交的参数信息
//        7 :发包
        HttpResponse httpResponse = httpClient.execute(get);

        httpResponse.getAllHeaders(); //所有的请求头信息
        httpResponse.getStatusLine(); //获得状态行
        httpResponse.getEntity(); //获得响应体

        HttpEntity entity = httpResponse.getEntity();
        String string = EntityUtils.toString(entity);
        System.out.println(string);


    }
}
