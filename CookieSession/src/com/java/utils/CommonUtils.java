package com.java.utils;

import javax.servlet.http.Cookie;

public class CommonUtils {
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
}
