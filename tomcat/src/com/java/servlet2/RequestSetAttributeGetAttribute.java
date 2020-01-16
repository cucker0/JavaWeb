package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestSetAttributeGetAttribute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在request中设置属性和值
        request.setAttribute("appid", "jw1001");
        // 获取request中的属性值，
        // 不同的请求不共享，只在同一个HttpServletResponse对象中能访问到
        Object appid = request.getAttribute("appid");
        System.out.println(appid);
    }
}
