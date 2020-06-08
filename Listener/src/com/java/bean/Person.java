package com.java.bean;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * session属性值对象随Session活化、钝化监听器
 *
 * 前提条件：
 * 1. 需要实现 HttpSessionActivationListener、Serializable接口
 * 2. 只有该类的对象一属性添加到了session对象中，才能随session的钝化、活化时被监听并执行相应的函数
 */
public class Person implements HttpSessionActivationListener, Serializable {
    private Long id;
    private String name;

    // 构造器
    public Person() {}

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 在session钝化时，当前对象自动执行的函数
     * 在tomcat正常关闭时执行
     *
     * @param se
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println(LocalDateTime.now() + ", " + toString() + "对象被钝化了");
    }

    /**
     * 在session活化时，当前对象自动执行的函数
     * 在启动tomcat时执行
     *
     * @param se
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println(LocalDateTime.now() + ", " + toString() + "对象被活化了");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
