package com.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应头中的Content-Type
        response.setContentType("text/html; charset=UTF-8");

        // 获取response的输出字符流
        PrintWriter pw = response.getWriter();
        // 向输出流中输出字符串
        pw.write("<html lang=\"en\">\n");
        pw.write("<head>\n");
        pw.write("    <meta charset=\"UTF-8\">\n");
        pw.write("    <title>JSP</title>\n");
        pw.write("</head>\n");
        pw.write("<body>\n");
        pw.write("    <h3>JSP</h3>\n");
        pw.write("    <div>这是一个html页面</div>\n");
        pw.write("</body>\n");
        pw.write("</html>\n");
    }
}
