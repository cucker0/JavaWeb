package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * URL重定向
 */
public class Redirect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这个API被废弃，请求新的API");
        // 指定重定向的地址，同时把响应状态码设置为302
        response.sendRedirect("/tomcat/servlet2/home.html");

        // 设置Location请求头 与response.sendRedirect() URL重定向的效果相同
        // 设置响应状态码
//        response.setStatus(302);
//        response.setHeader("Location", "https://www.baidu.com");
    }
}
