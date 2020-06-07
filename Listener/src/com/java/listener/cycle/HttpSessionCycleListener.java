package com.java.listener.cycle;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * HttpSession生命周期监听器，全局有效
 */
public class HttpSessionCycleListener implements HttpSessionListener {
    // 保存session id的set
    private static Set<String> sessions = new HashSet<>();

    // 方法
    /**
     * session对象创建时自定执行的函数
     * 第一次需要使用session时
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(LocalDateTime.now() + ", Session对象创建了, session id: " + se.getSession().getId());
        addSession(se.getSession());
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
        deleteSessionById(se.getSession().getId());
    }

    public static void addSession(HttpSession session) {
        sessions.add(session.getId());
    }

    public static void deleteSessionById(String sessionId) {
        sessions.remove(sessionId);
    }

    public static Set<String> getSessions() {
        return sessions;
    }
}
