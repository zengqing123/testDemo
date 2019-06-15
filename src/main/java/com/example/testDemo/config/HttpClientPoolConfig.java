package com.example.testDemo.config;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

/**
 * <b>类   名：</b>HttpClientPoolConfig<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>luozengqing<br/>
 * <b>创建时间：</b>2019/6/5 13:24<br/>
 * <b>修改人：</b>luozengqing<br/>
 * <b>修改时间：</b>2019/6/5 13:24<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
public class HttpClientPoolConfig {
    private PoolingHttpClientConnectionManager connectionManager = null;
    @PostConstruct
    public void init() {
        System.out.println("httpPool初始化开始");
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        connectionManager =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);
    }
    public CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(connectionManager).build();
    }



}
