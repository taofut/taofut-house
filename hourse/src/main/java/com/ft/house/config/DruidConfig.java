package com.ft.house.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 创建人：taofut
 * 创建时间：2019-06-30 16:44
 * 描述：
 */
@Configuration
public class DruidConfig {

    //跟配置文件绑定
    //spring.druid.xx xx跟DruidDataSource里的属性绑定
    @ConfigurationProperties(prefix = "spring.druid")
    //spring容器启动时，DruidDataSource调用内部init方法启动，关闭时，调用内部close方法关闭
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return dataSource;
    }

    /**
     * 定义慢sql的Filter，出现慢sql可以打印出来
     * @return
     */
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        //设定多长时间属于慢SQL  这里设置为5秒属于慢SQL
        statFilter.setSlowSqlMillis(5000);
        //设置是否打印慢SQL日志
        statFilter.setLogSlowSql(true);
        //是否将日志合并
        statFilter.setMergeSql(true);
        return statFilter;
    }

    /**
     * 添加监控bean 用来监控慢SQL日志等等
     * 服务启动后，输入地址：http://localhost:8080/druid/index.html查看监控
     * 如果存在慢SQL，则控制台会打印出来
     * 例如：slow sql 21 millis. select id,name,phone,email from user[]
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }

}
