package com.java.listener.cycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

/**
 * ServletContext生命周期监听器，全局有效
 */
public class ServletContextCycleListener implements ServletContextListener {
    /**
     * ServletContext对象在创建时自动调用的函数
     * 在tomcat启动时
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(LocalDateTime.now() + ", ServletContext对象被创建了, getServletContext: " + sce.getServletContext());
    }

    /**
     * ServletContext对象在销毁时自动调用的函数
     * 在tomcat正常关闭时
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(LocalDateTime.now() + ", ServletContext对象被销毁了, getServletContext: " + sce.getServletContext());
        System.out.println(sce.getSource());
    }
}
