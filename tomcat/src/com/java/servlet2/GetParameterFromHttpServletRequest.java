package com.java.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 从HttpServletRequest中获取参数
 *
 * request.getParameter(fieldString) 即使客户端传过来的时一个数组，也只能获取到第一个值
 *
 */
public class GetParameterFromHttpServletRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request编码字符集，解决乱码问题
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String[] courses = request.getParameterValues("course");

        StringBuilder course_str = new StringBuilder("[ ");
        for (String course: courses) {
            course_str.append(course).append(", ");
        }
        course_str.append(" ]");

        System.out.printf("username:%s  password:%s  sex:%s course:%s", username, password, sex, course_str.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * request获取的参数，为中文是出现乱码，
         * 主要原因是，服务端默认使用ISO-8859-1字符集进行解码，客户端使用UTF-8字符集进行编码
         */

        /**
         * 解决方法1: 字符串转码
         * 获取到乱码的参数值后，先用ISO-8859-1字符集进行编码，在用UTF-8字符集解码
         *
         * username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
         */

        /**
         * 结局方法2: 给request对象指定编码字符集.
         * request.setCharacterEncoding("UTF-8");
         * 在使用前先设置
         */
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String sex = request.getParameter("sex");
//        String course = request.getParameter("course"); // 即使客户端传过来的时一个数组，也只能获取到第一个值
        String[] courses = request.getParameterValues("course");

        StringBuilder course_str = new StringBuilder("[ ");
        for (String course: courses) {
            course_str.append(course).append(", ");
        }
        course_str.append(" ]");

        System.out.printf("username:%s  password:%s  sex:%s course:%s", username, password, sex, course_str.toString());

    }
}
