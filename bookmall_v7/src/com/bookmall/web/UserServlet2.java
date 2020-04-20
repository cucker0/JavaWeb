package com.bookmall.web;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet2 extends HttpServlet {
    private UserService userService;

    // 构造器
    public UserServlet2() {
        super();
        userService = new UserServiceImpl();
    }

    // 方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request的解码字符集
        request.setCharacterEncoding("UTF-8");
        // 从request中获取参数
        String action = request.getParameter("action");

        // 根据action值调用不同的业务逻辑方法
//        if (action.equalsIgnoreCase("login")) {
//            login(request, response);
//        } else if (action.equalsIgnoreCase("register")) {
//            register(request, response);
//        }

        /*
         * 当有很多业务方法时，像上面的写法就需要写很多的if分支
         *
         * 改进方法：
         * 通过反射获取业务方法，
         * 前提条件是客户端请求参数 action值要与下面的方法对应上
         */
        Class clazz = getClass();
        try {
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("方法调用失败");
            e.printStackTrace();
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从request中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(new User(null, username, password, ""));
        System.out.println(user);
        // save username to request object
        request.setAttribute("username", username);
        if (user == null) {
            System.out.println("用户名或密码错误，登录失败！");
            // 把需要返回给客户端的提示信息，保存到 request与对象中
            request.setAttribute("tips", "用户名或密码错误，登录失败！");
            // 转发请求由另一个Servlet来处理
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
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
            request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
        }
    }
}
