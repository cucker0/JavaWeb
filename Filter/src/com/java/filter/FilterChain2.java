package com.java.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterChain2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("访问资源前，FilterChain2 doFilter开始执行");
        chain.doFilter(req, resp);
        System.out.println("访问资源后，FilterChain2 doFilter执行结束");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
