package com.java.bean;

import java.io.Serializable;

public class Person implements Serializable {
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
