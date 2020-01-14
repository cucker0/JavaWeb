package com.java.servlet2;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取ServletContext对象
        ServletContext servletContext = getServletContext();
        // ServletContext对象可以保存数据、获取数据
        // 这些数据叫属性，以map(k-v)的形式保存数据
        servletContext.setAttribute("num", 100);
        Object num = servletContext.getAttribute("num");
        System.out.println("ContextServlet1 获取保存的数据num：" + num);
    }
}
