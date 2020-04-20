package com.java.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterChain1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("访问资源前，FilterChain1 doFilter开始执行");
        chain.doFilter(req, resp);
        System.out.println("访问资源后，FilterChain1 doFilter执行结束");
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
