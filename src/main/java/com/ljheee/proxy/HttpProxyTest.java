package com.ljheee.proxy;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lijianhua04 on 2018/8/15.
 */
public class HttpProxyTest {


    static {
        HttpProxy.init();
    }


    /**
     * 静态代理，实现http拦截
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        URLConnection conn = url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.connect();
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write("a=c&b=1".getBytes());

        InputStream inputStream = conn.getInputStream();
        byte[] bytes = sun.misc.IOUtils.readFully(inputStream, -1, false);
        System.out.println(new String(bytes));

    }
}
