package com.ft.house.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author: fut
 * Time:   2019-07-01
 * Motto:  Work conscientiously and be a practical man.
 */
@Data
@ConfigurationProperties(prefix = "spring.httpclient")
public class HttpClientProperties {

    private Integer connectTimeOut=1000;

    private Integer socketTimeOut=10000;

    private String agent="agent";

    private Integer maxConnPerRoute=10;

    private Integer maxConnTotal=50;


}
