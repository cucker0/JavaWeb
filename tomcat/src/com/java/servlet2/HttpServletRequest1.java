package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest类的常用方法
 *
 */
public class HttpServletRequest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.getRequestURI() 获取请求的资源路径
        String uri = request.getRequestURI();
        System.out.println("request.getRequestURI() 获取请求的资源路径: " + uri);

        // request.getRequestURL() 获取请求的统一资源定位器
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("request.getRequestURL() 获取请求的统一资源定位器: " + requestURL);

        // request.getRemoteHost() 获取请求的客户端的地址
        String remoteHost = request.getRemoteHost();
        System.out.println("request.getRemoteHost() 获取请求的客户端的地址: " + remoteHost);


        // request.getHeader("user-agent") 获取指定的http header头属性值(字段值)
        String userAgent = request.getHeader("user-agent");
        System.out.println("equest.getHeader(\"user-agent\") 获取指定的http header头属性值: " + userAgent);

        // request.getMethod()获取请求的的方法
        String method = request.getMethod();
        System.out.println("request.getMethod()获取请求的的方法:" + method);
    }
}
