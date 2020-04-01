package com.java.web;

import com.java.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 利用cookie，一段时间内免登录
 *
 * manager
 */
public class LoginServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username").strip();
        String password = request.getParameter("pwd").strip();

        // 假设系统一个用户的用户名：admin，密码: ad123456
        if ("admin".equalsIgnoreCase(username) && "ad123456".equals(password)) {
            Cookie ck = new Cookie("user", username);
            // 设置用户cookie 过期时间
            ck.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(ck);
            System.out.println("登录成功");
            response.sendRedirect(request.getContextPath() + "/manager/user_home.jsp");
        } else {
            System.out.println("登录失败");
            request.setAttribute("tips", "用户或密码不正确");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie user = CommonUtils.getCookieByName(request.getCookies(), "user");
        if (user  != null) {
            // 通知客户客户端立即删除该cookie
            user.setMaxAge(0);
            response.addCookie(user);
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
