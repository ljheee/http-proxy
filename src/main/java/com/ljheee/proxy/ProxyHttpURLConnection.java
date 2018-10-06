package com.ljheee.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 */
public class ProxyHttpURLConnection extends URLConnection {

    URLConnection urlConnection;
    URL url;

    public ProxyHttpURLConnection(URLConnection urlConnection, URL url) {
        super(url);

        this.urlConnection = urlConnection;
        this.url = url;

    }


    @Override
    public void connect() throws IOException {

        long begin = System.currentTimeMillis();
        this.urlConnection.connect();
        long end = System.currentTimeMillis();
        System.out.println("Used Time=" + (end - begin));
    }


  @Override
    public OutputStream getOutputStream() throws IOException {
        return urlConnection.getOutputStream();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return urlConnection.getInputStream();
    }

    @Override
    public boolean getDoOutput() {
        return urlConnection.getDoOutput();
    }

    @Override
    public void setDoOutput(boolean dooutput) {
        urlConnection.setDoOutput(dooutput);
    }

    @Override
    public boolean getDoInput() {
        return urlConnection.getDoInput();
    }

    @Override
    public void setDoInput(boolean doinput) {
        urlConnection.setDoInput(doinput);
    }
}
