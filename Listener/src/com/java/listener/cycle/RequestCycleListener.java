package com.java.listener.cycle;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.time.LocalDateTime;

/**
 * Request生命周期监听器
 */
public class RequestCycleListener implements ServletRequestListener {
    public RequestCycleListener() {}

    /**
     * request对象销毁时自动调用的函数
     * 请求完成时
     *
     * @param sre
     */
    // 方法
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(LocalDateTime.now() + ", request对象被销毁了, ServletRequest: " + sre.getServletRequest() +
                ", ServletContext: " + sre.getServletContext()
        );
        System.out.println("    ===>RemoteAddr: " + sre.getServletRequest().getRemoteAddr() + ", RemotePort: " + sre.getServletRequest().getRemotePort());
        System.out.println("    ===>RemoteHost: " + sre.getServletRequest().getRemoteHost());
    }

    /**
     * request对象在创建时自动调用的函数
     *  请求进来时
     *
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(LocalDateTime.now() + ", request对象被创建了, ServletRequest: " + sre.getServletRequest() +
                ", ServletContext: " + sre.getServletContext()
        );
        System.out.println("    ===>RemoteAddr: " + sre.getServletRequest().getRemoteAddr() + ", RemotePort: " + sre.getServletRequest().getRemotePort());
        System.out.println("    ===>RemoteHost: " + sre.getServletRequest().getRemoteHost());
    }
}
