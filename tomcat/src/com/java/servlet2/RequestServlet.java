package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * request常用方法
 *
 */
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("request.getRequestURI(): " + uri);

        StringBuffer url = request.getRequestURL();
        System.out.println("request.getRequestURL(): " + url);

        String remoteHost = request.getRemoteHost();
        System.out.println("request.getRemoteHost(): " + remoteHost);

        String header = request.getHeader("user-agent");
        System.out.println("request.getHeader(\"user-agent\"): " + header);

        String host = request.getHeader("host");
        System.out.println("request.getHeader(\"host\"): " + host);

        String method = request.getMethod();
        System.out.println("request.getMethod(): " + method);

    }
}
