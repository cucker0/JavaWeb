package com.java.listener.cycle;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;

/**
 * HttpSession生命周期监听器
 */
public class HttpSessionCycleListener implements HttpSessionListener {
    /**
     * session对象创建时自定执行的函数
     * 第一次需要使用session时
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(LocalDateTime.now() + ", Session对象创建了, session id: " + se.getSession().getId());
    }

    /**
     * session对象被销毁时自动执行的函数
     * session对象自动超时的时候(过了最大不活动时间)或手动执行 session.invalidate()方法使session无效时
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(LocalDateTime.now() + ", Session对象被销毁了, session id: " + se.getSession().getId());
    }
}
