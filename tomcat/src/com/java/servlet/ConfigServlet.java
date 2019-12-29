package com.java.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConfigServlet")
public class ConfigServlet extends HttpServlet {
    public ConfigServlet() {}

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 获取Servlet配置的<servlet-name></<servlet-name>>值
        String servletName = config.getServletName();
        System.out.println("servletName:" + servletName);

        // 获取Servlet配置的初始化参数<init-param></init-param>
        String username = config.getInitParameter("username");
        String driverClass = config.getInitParameter("driverClass");
        System.out.printf("username:%s driverClass:%s\n", username, driverClass);

        // 获取ServletContext对象
        ServletContext servletContext = config.getServletContext();
        System.out.println("servletContext:" + servletContext);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
