package com.bookmall.bean;

/**
 * 图书作者
 */
public class Author {
    private int id;
    private String name;
    // 作者简介
    private String brief;

    // 构造器
    public Author() {}

    public Author(int id, String name, String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }

    // 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}
