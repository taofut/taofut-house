package com.ft.house.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 创建人：taofut
 * 创建时间：2019-06-30 15:02
 * 描述：
 */
public class LogFilter implements Filter {

    private Logger logger= LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("请求到来...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }


}
