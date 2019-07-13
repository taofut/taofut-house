package com.ft.house.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 15:06
 * 描述：
 */
@Configuration
public class FilterBeanConfig {

    /**
     * 1. 构造filter
     * 2. 配置拦截器urlPattern
     * 3. 利用FilterRegistrationBean进行包装
     * @return
     */
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());
        List<String> urlList=new ArrayList<>();
        urlList.add("*");
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }

}
