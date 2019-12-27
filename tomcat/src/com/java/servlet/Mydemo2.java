package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 利用IDEA创建Servlet
 * 其实就是直接继承HttpServlet抽象类，并在web.xml文件中自动配置serlet等
 */
@WebServlet(name = "Mydemo2")
public class Mydemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mydemo2 处理post请求");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mydemo2 处理get请求");
    }
}
