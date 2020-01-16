package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应客户端内容
 *
 */
public class HttpServletResponse1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 告诉客户端发送的内容的使用的编码字符集
        // 效果同下
        // response.setHeader("Content-Type\"", "text/html; charset=UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        // 获取字符输出流
        PrintWriter writer = response.getWriter();
        writer.println("<h4>这是服务器端响应的数据</h4>");
    }
}
