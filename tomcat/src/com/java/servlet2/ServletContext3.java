package com.java.servlet2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContext3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        // 获取web.xml配置中所有Servlet使用的全局初始化参数。但不能获取单个<servlet>标签内的参数
        String username = servletContext.getInitParameter("username");
        System.out.println("从web.xml中的context-param获得的username值：" + username);

        // 获取工程名
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

        // getRealPath(str) 获目录或文件的绝对路径
        System.out.println("/的绝对路径：" + servletContext.getRealPath("/"));
        System.out.println("/css目录的绝对路径：" + servletContext.getRealPath("/css"));
        System.out.println("/img/logo.png的绝对路径："+ servletContext.getRealPath("/img/logo.png"));
    }
}
