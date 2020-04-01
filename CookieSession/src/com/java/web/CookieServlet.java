package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("no", "xs1001");
        /*
        * 把cookie信息添加到response对象中
        *
        * 在response headers中添加一行Set-Cookie: no=xs1001
        * response.addCookie(cookie);主要是添加了一个response header，效果同response.addHeader("Set-Cookie", "no=xs1001");
        * */
        response.addCookie(cookie);
        response.getWriter().write("cookie 创建成功，name为no");
    }

    /**
     * 从cookie数组返回指定name的cookie
     *
     * @param cookies
     * @param cookieName
     * @return
     */
    public static Cookie getCookieByName(Cookie[] cookies, String cookieName) {
        if (cookies == null || cookieName.isEmpty()) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookieName.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从request中获取所有cookie信息，获取到的是一个数组
        Cookie[] cookies = request.getCookies();
        Cookie cookie = getCookieByName(cookies, "no");
        System.out.println("名为no的cookie: " + cookie);
        response.getWriter().write("名为no的cookie的值 : " + cookie.getValue());
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 方法1：新建一个同名的cookie，返回给客户端response
        // Cookie cookie = new Cookie("no", "xs2002");
        // response.addCookie(cookie);

        // 方法2：先获取指定名的cookie,再修改该cookie值，最后把更新后的cookie添加到respose对象中
        Cookie cookie = getCookieByName(request.getCookies(), "no");
        cookie.setValue("xs5005");
        response.addCookie(cookie);
        response.getWriter().write("cookies修改完成，名为no的cookie的新值为：" + cookie.getValue());
    }

    /**
     * cookie的默认生命周期
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void  defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cook1 = new Cookie("ck1", "coronavirus2020-1-24");
        Cookie cook2 = new Cookie("ck2", "sn263331");
        cook2.setMaxAge(-1);
        response.addCookie(cook1);
        response.addCookie(cook2);
    }

    protected void  deleteCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie ck = getCookieByName(cookies, "no");
        if (ck != null) {
            // maxAge = 0 时，表示让客户端立即删除该cookie
            ck.setMaxAge(0);
            response.addCookie(ck);
            response.getWriter().write("删除name为no的cookie");
        }
    }

    protected void  setCookieMaxAge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ck = new Cookie("username", "zhaoliu");
        ck.setMaxAge(1800);
        response.addCookie(ck);
        response.getWriter().write("创建名为username的cookie，" + "1800秒后过期");
    }

    protected void  setCookiePath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("superUser", "admin");
        cookie.setPath(request.getContextPath() + "/manager");
        response.addCookie(cookie);
        response.getWriter().write("已添加一个有path限制的cookie");
    }
}
