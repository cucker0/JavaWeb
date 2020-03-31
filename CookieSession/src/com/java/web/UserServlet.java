package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "ad123456".equals(password)) {
            HttpSession session = request.getSession();
            // 登录成功，在session域对象中添加一个user属性，值为用户名
            session.setAttribute("user", username);
            response.sendRedirect("secret_book/index.jsp");
            return;
        }
        request.getRequestDispatcher("secret_book/login.jsp").forward(request, response);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 删除session域对象中的user属性
        session.removeAttribute("user");
        response.sendRedirect("secret_book/index.jsp");
    }
}
