package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ( "admin".equalsIgnoreCase(username) && "py123456".equalsIgnoreCase(password) ) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie ck = new Cookie("JSESSIONID", session.getId());
            ck.setMaxAge(60 * 60 * 24 * 5);
            response.addCookie(ck);
            response.sendRedirect(request.getContextPath() + "/admin/user_center.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}