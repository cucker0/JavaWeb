package com.bookmall.web;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置request的解码字符集
        request.setCharacterEncoding("UTF-8");
        // 从request中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(null, username, password, ""));
        System.out.println(user);
        if (user == null) {
            System.out.println("用户名或密码错误，登录失败！");
            request.getRequestDispatcher("pages/user/login.html").forward(request, response);
        } else {
            System.out.println("登录成功");
            request.getRequestDispatcher("pages/user/regist_success.html").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("LoginServlet doGet");
    }
}
