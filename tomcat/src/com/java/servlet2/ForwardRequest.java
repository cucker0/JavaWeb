package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发请求
 *
 * 在getRequestDispatcher(urlStrig)中，
 * / 表示http://ip:port/工程名/
 * 也就是与web目录对应
 */
public class ForwardRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ForwardRequest Servlet接受到了请求，现在把请求转到其他URL去处理");
        // 转发请求，相当于把任务转派给别人处理了
        request.getRequestDispatcher("/servlet2/forward.html").forward(request, response);
    }
}
