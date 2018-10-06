package com.ljheee.proxy;

import sun.net.www.protocol.http.Handler;

import java.io.IOException;
import java.net.*;

/**
 * Http 代理类
 */
public class HttpProxy {


    public static void init() {
        URL.setURLStreamHandlerFactory(new ProxyURLStreamHandlerFactory());
    }

    private static class ProxyURLStreamHandlerFactory implements URLStreamHandlerFactory {

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {

            if (protocol.equals("http")) {
                return new AgentHttpHandler();

            } else if (protocol.equals("https")) {
                return new AgentHttpsHandler();
            }

            return null;
        }

        private class AgentHttpHandler extends Handler {
            @Override
            protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                HttpURLConnection urlConnection = (HttpURLConnection) super.openConnection(url, proxy);
                return new ProxyHttpURLConnection(urlConnection, url);
            }

            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return openConnection(u, null);
            }
        }

        private class AgentHttpsHandler extends Handler {
            @Override
            protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                HttpURLConnection urlConnection = (HttpURLConnection) super.openConnection(url, proxy);
                return new ProxyHttpURLConnection(urlConnection, url);
            }

            @Override
            protected URLConnection openConnection(URL u) throws IOException {
                return openConnection(u, null);
            }
        }
    }
}
