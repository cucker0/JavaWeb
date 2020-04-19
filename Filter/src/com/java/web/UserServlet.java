package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ( "admin".equalsIgnoreCase(username) && "py123456".equalsIgnoreCase(password) ) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie ck = new Cookie("JSESSIONID", session.getId());
            ck.setMaxAge(60 * 60 * 24 * 5);
            response.addCookie(ck);
            response.sendRedirect(request.getContextPath() + "/admin/login_success.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
        }
    }

    protected void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
            return;
        }
        System.out.println("request.getRequestURI(): " + request.getRequestURI());
        System.out.println("request.getRequestURL(): " + request.getRequestURL());
        request.getRequestDispatcher(request.getRequestURI());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkLogin(request, response);
    }
}