package com.java.listener.attribute;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import java.time.LocalDateTime;

/**
 * ServletRequestAttribute监听器，全局有效
 */
public class RequestAttributeListener implements ServletRequestAttributeListener {
    /**
     * 在Request对象添加了属性时，自动执行的函数
     *
     * @param srae
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println(LocalDateTime.now() + ", request对象添加了一个属性，属性名:" + srae.getName() + ", 值：" + srae.getValue());
    }

    /**
     * 在Request对象删除属性时，自动执行的函数
     *
     * @param srae
     */
    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println(LocalDateTime.now() + ", request对象删除了一个属性，属性名:" + srae.getName());
    }

    /**
     * 在Request对象修改了属性值时，自动执行的函数
     *
     * 每次请求都出现类似下面的信息：
     * 2020-06-07T22:46:43.304069600, request对象属性名：org.apache.catalina.ASYNC_SUPPORTED 的值被修改了
     *     旧值：true, 新值：false
     * org.apache.catalina.ASYNC_SUPPORTED:true；设置请求支持异步处理，
     * tomcat容器在每次请求时会自动增加属性org.apache.catalina.ASYNC_SUPPORTED，值为true会设置会可异步处理，false反之。
     *
     *
     * @param srae
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println(LocalDateTime.now() + ", request对象属性名：" + srae.getName() + " 的值被修改了\n" +
                "   旧值：" + srae.getValue() + ", 新值：" + srae.getServletRequest().getAttribute(srae.getName()));
    }
}
