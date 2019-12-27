package com.java.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 手动实现Servlet接口
 */
public class Mydemo implements Servlet {
    // 构造器
    public Mydemo() {
        System.out.println("Mydemo 空参构造器");
    }

    // 方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Mydemo init方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("接受到了客户端请求, "+ System.currentTimeMillis());
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String method = httpRequest.getMethod();
        if (method.equalsIgnoreCase("get")) {
            System.out.println("客户端个请求方法为get");
        } else if (method.equalsIgnoreCase("post")) {
            System.out.println("客户端个请求方法为post");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁了");
    }
}
