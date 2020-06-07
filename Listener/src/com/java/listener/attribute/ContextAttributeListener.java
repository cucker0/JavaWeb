package com.java.listener.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.time.LocalDateTime;

/**
 * ServletContextAttribute监听器，全局有效
 */
public class ContextAttributeListener implements ServletContextAttributeListener {

    /**
     * ServletContext对象在添加属性时自动调用的函数
     *
     * @param scae
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println(LocalDateTime.now() + "，ServletContext对象添加了一个属性，属性名：" + scae.getName() + ", 属性值：" + scae.getValue());
    }

    /**
     * ServletContext对象在移除属性时自动调用的函数
     *
     * @param scae
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println(LocalDateTime.now() + "，ServletContext对象移除了一个属性，属性名：" + scae.getName() + ", 属性值：" + scae.getValue());
    }

    /**
     * ServletContext对象在替换属性值时自动调用的函数
     *
     * @param scae
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println(LocalDateTime.now() + "，ServletContext对象更新了一个属性，" +
                "\n    属性名：" + scae.getName() + ", 属性旧值：" + scae.getValue() +
                "，属性新值：" + scae.getServletContext().getAttribute(scae.getName())
        );
    }
}
