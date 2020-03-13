package com.bookmall.bean;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private Integer id;
    private String name;
    private double price;
    // 销量
    private int sales;
    // 库存量
    private int stock;
    // 图书图片路径
    private String imgPath;
    // 作者ID列表
    private List<Integer> authors;
    // 出版社ID
    private int publisherId;
    // 出版日期
    private LocalDate time;

    // 构造器
    public Book() {}

    public Book(Integer id, String name, double price, int sales, int stock, String imgPath, List<Integer> authors, int publisherId, LocalDate time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
        this.authors = authors;
        this.publisherId = publisherId;
        this.time = time;
    }

    // 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Integer> authors) {
        this.authors = authors;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                ", authors=" + authors +
                ", publisherId=" + publisherId +
                ", time=" + time +
                '}';
    }
}
