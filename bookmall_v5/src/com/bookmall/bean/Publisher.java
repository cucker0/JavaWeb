package com.bookmall.bean;

/**
 * 出版社
 */
public class Publisher {
    private int id;
    // 出版社名称
    private String name;

    // 构造器
    public Publisher() {}

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
