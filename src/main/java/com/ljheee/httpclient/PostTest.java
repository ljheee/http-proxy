package com.ljheee.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * * httpClient post请求
 */
public class PostTest {
    public static void main(String[] args) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        String url = "http://39.108.136.60:8380/ningmengban/mvc/user/login.json";
        HttpPost post = new HttpPost(url);

        post.setHeader("Accept", "application/json");
        post.setHeader("Content-Type", "application/x-www-form-urlencoded");

        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("username", "2544"));
        parameters.add(new BasicNameValuePair("password", "2544"));
        post.setEntity(new UrlEncodedFormEntity(parameters));

        HttpResponse httpResponse = httpClient.execute(post);

        HttpEntity entity = httpResponse.getEntity();
        String string = EntityUtils.toString(entity);
        System.out.println(string);


    }
}
