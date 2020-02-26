package com.bookmall.web;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService;

    public RegisterServlet() {
        super();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("RegisterServlet doPost");
        // 设置request的编码字符集，解决中文乱码
        request.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        // save user info to request object
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("email", email);

        // 验证码暂时不从服务器生成，直接使用一个固定的
        String validCode = "abcde";
        System.out.println("code: " + code);
        if (validCode.equalsIgnoreCase(code)) {
            boolean existUsername = userService.existUsername(username);
            if (existUsername) {
                // 用户名存在
                System.out.println("用户名已经存在，注册失败");
                // 向request与对象中保存提示信息
                request.setAttribute("tips", "用户名已经存在，注册失败");

                // 响应注册页面内容
                /**
                 * 在请求转发中，
                 * / 表示 http://ip:port/工程名/   与web目录对应
                 */
                request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
            } else {
                // 可注册的用户，开始注册
                userService.register(new User(0, username, password, email));
                // 用户注册后，跳转到成功注册页面
                request.getRequestDispatcher("pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            System.out.println("验证码错误，注册失败");
            request.setAttribute("tips", "验证码错误，注册失败");

            // 转发到注册URL，由该页面响应
            request.getRequestDispatcher("pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("RegisterServlet doGet");
    }
}
