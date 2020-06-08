package com.java.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.time.LocalDateTime;

/**
 * session对象绑定监听器
 * 一个对象添加为session属性值时
 * session属性值为该对象的属性删除时
 *
 */
public class User implements HttpSessionBindingListener {
    private Long id;
    private String name;
    private String password;

    // 构造器
    public User() {}

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * 对象在绑定为session对象的属性值时，自动调用的函数
     *     session对象添加一个属性，值设置为该对象时
     *     把session的key值修改给此对象，也会触发
     *
     * @param event
     */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(LocalDateTime.now() + ", " + toString() + "对象作为属性值被添加到session对象中，key为： " + event.getName() +
                "\n   session id: " + event.getSession().getId()
        );
    }

    /**
     * 对象作为session对象的属性值在解绑时，自动调用的函数
     * 即删除session的属性值为该对象的属性在删除的时候，或是原session key为该类对象的值被修改为其他任何值的时候
     *
     * @param event
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(LocalDateTime.now() + ", session对象中的属性值为: " + toString() + "的key被解绑了，key：" + event.getName() +
                "\n   session id: " + event.getSession().getId()
        );
    }
}
