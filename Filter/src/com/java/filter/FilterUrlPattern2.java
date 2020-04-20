package com.java.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterUrlPattern2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterUrlPattern2: " + "/pages/*, /info/*");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
