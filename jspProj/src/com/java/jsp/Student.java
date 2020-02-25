package com.java.jsp;

public class Student {
    private int id;
    private String name;
    private String phone;

    // 构造器
    public Student() {}

    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
