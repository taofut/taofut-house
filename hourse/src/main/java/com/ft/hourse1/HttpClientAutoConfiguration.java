package com.ft.hourse1;

import com.ft.house.autoconfig.HttpClientProperties;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: fut
 * Time:   2019-07-01
 * Motto:  Work conscientiously and be a practical man.
 * 疑问1：该类是怎么加载进来的？
 * 所有被@Configuration注解的类，如果该类所在目录是springboot启动类下的同级目录或子目录，
 * 都会被spring所加载。
 * 反之，如果该类不在springboot启动类目录下，那么想要让它加载则需要在resoures/META-INF/pring.factories文件里指定
 */
@Configuration
//HttpClient.java存在的情况下，才加载HttpClientAutoConfiguration
@ConditionalOnClass(HttpClient.class)
//将HttpClientProperties作为一个bean注入spring容器中
@EnableConfigurationProperties(HttpClientProperties.class)
public class HttpClientAutoConfiguration {

    @Autowired
    private HttpClientProperties properties;

//    public HttpClientAutoConfiguration(HttpClientProperties properties) {
//        this.properties = properties;
//    }

    @Bean
    //在用户未定义httpClient这个bean时，才加载
    @ConditionalOnMissingBean
    public HttpClient httpClient() {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(properties.getConnectTimeOut())
                .setSocketTimeout(properties.getSocketTimeOut()).build();
        HttpClient client= HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).setUserAgent(properties.getAgent())
                .setMaxConnPerRoute(properties.getMaxConnPerRoute()).setConnectionReuseStrategy(new NoConnectionReuseStrategy()).build();
        return client;
    }

}
