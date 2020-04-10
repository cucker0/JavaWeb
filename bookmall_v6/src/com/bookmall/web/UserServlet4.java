package com.bookmall.web;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.serviceimpl.UserServiceImpl;
import com.bookmall.utils.Beanutils;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet4 extends BaseServlet {
    private UserService userService;

    // 构造器
    public UserServlet4() {
        super();
        userService = new UserServiceImpl();
    }

    // 方法
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从request中获取参数
/*
        String username = request.getParameter("username");
        String password = request.getParameter("password");
*/

        // 当user对象有很多属性值要从request对象中获取时，要写很多个，不方便，借助于BeanUtils工具就很方便了
        // 把request请求中的参数，注入到Bean对象中，并返回该Bean对象
        User user = Beanutils.copyParams2Bean(request.getParameterMap(), new User());
        User user1 = userService.login(user);
        String code = request.getParameter("code");
        // 使用了kaptcha验证码，会自动在session对象中添加KAPTCHA_SESSION_KEY属性保存验证码值
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        // 已经登录，跳转到首页
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath());
            return;
        }

        // 登录成功
        if (token.equalsIgnoreCase(code) && user1 != null) {
            System.out.println("登录成功");
            // 获取或创建session
            HttpSession session = request.getSession();
            // 设置保存session id的cookie有效时间，单位:s
            Cookie ck = new Cookie("JSESSIONID", session.getId());
            ck.setMaxAge(60 * 60 * 24 * 5);
            response.addCookie(ck);
            // 在session对象中添加user属性值
            session.setAttribute("user", user1);
            // request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
            return;
        }
        // 登录失败
        else if (!token.equalsIgnoreCase(code)) {
            System.out.println("验证码错误，登录失败！");
            // 把需要返回给客户端的提示信息，保存到 request与对象中
            request.setAttribute("tips", "验证码错误，登录失败！");

        } else {
            request.setAttribute("tips", "用户名或密码错误，登录失败！");
        }
        String username = request.getParameter("username");
        request.setAttribute("username", user.getUsername());
        // 转发请求由另一个Servlet来处理
        request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
/*      String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
 */
        User user = Beanutils.copyParams2Bean(request.getParameterMap(), new User());
        String code = request.getParameter("code");
        // save user info to request object
        request.setAttribute("user", user);
        // KAPTCHA验证码
        HttpSession session = request.getSession();
        String validCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 取出session中的KAPTCHA验证码后，删除给属性，避免重复提交表单
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("code: " + code);
        if (validCode.equalsIgnoreCase(code)) {
            boolean existUsername = userService.existUsername(user.getUsername());
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
                userService.register(user);
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

    // 退出登录
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 删除session对象中的user属性
        request.getSession().removeAttribute("user");
        // 让客户端URL跳转到首页
        response.sendRedirect(request.getContextPath());
    }
}
