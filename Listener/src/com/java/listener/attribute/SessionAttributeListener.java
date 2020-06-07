package com.java.listener.attribute;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;

/**
 * SessionAttribute监听器，全局有效
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
    /**
     * 在session对象添加了属性时，自动执行的函数
     *
     * @param se
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println(LocalDateTime.now() + ", session id为：" + se.getSession().getId() + "的对象添加了属性，属性名：" + se.getName() + ", 值：" + se.getValue());
    }

    /**
     * 在session对象修移除属性时，自动执行的函数
     *
     * @param se
     */
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println(LocalDateTime.now() + ", session id为：" + se.getSession().getId() + "的对象移除了属性，属性名：" + se.getName());
    }

    /**
     * 在session对象修改了属性值时，自动执行的函数
     *
     * @param se
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println(LocalDateTime.now() + ", session id为：" + se.getSession().getId() + "的对象添加了属性，属性名：" + se.getName() +
                ",\n    旧值：" + se.getValue() + ", 新值：" + se.getSession().getAttribute(se.getName())
        );
    }
}
