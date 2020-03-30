package com.java.web;

import com.java.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * request.getSession() 获取session
        *       当session为空时，服务端创建session
        *       当session不为空，从服务器上查找该session，如果不存在，创建session，添加到服务器的内存中，并传给客户端(自动在response上添加一个cookie)，默认新创建session在浏览器关闭后销毁
        *                       格式：Set-Cookie: JSESSIONID=C02805F92A239A074DA3AE122BA4E232; Path=/cookieSession; HttpOnly
        *           如果存在，更新session最后一次访问时间
        *
        * session的是一个name为JSESSIONID的cookie
        * */
        HttpSession session = request.getSession();
        String id = session.getId();
        response.getWriter().write("session id: " + id);
        response.getWriter().write("<br>是否为新创建？ " + session.isNew());
    }

    protected void setSessionAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("age", 18);
        session.setAttribute("person", new Person("lvmeng", 1));
        response.getWriter().write("成功保存数据到session域对象");
    }

    protected void getSessionAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 给session域对象添加数据时，在服务器内存中的这个session对象中添加了属性，客户端的session信息不变，客户端记录了这个session id
        // 给session域对象添加属性时，属性值要可序列化
        response.getWriter().write("从session域对象中获取数据:<br>");
        response.getWriter().write("age: " + session.getAttribute("age"));
        response.getWriter().write("<br>person: " + session.getAttribute("person"));
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 最大不活动间隔时间(单位：秒)
        int maxInterval = session.getMaxInactiveInterval();
        response.getWriter().write("最大不活动间隔时间：" + maxInterval + "秒");
    }

    // 立即删除session
    protected void invalidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 这里只删除了服务器端内存中的session对象，不通知客户端删除名为SESSIONID的cookie
        // 当执行session.invalidate()后，客户端传过来的session ID也是无效的了，再获取时服务器会重新创建一个session
        session.invalidate();
        response.getWriter().write("session立即删除了");
    }

    // 设置最大不活动间隔时间，即超时时间
    protected void setMaxInactiveInterval(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // session.setMaxInactiveInterval(时间)
        // 单位：秒
        // 超时信息记录在服务端，同样修改超时时间不会通知客户端
        session.setMaxInactiveInterval(6);
        session.getLastAccessedTime();
        response.getWriter().write("session设置的默认超时时间：" + 6 + "秒");
    }

    protected void getSessionAfterCloseBrowser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie ck = new Cookie("JSESSIONID", session.getId());
        // 设置cookie的maxAge
        ck.setMaxAge(1800);
        response.addCookie(ck);
        response.getWriter().write("session半小时后过期，关闭浏览器后session仍可生效");
    }

}
