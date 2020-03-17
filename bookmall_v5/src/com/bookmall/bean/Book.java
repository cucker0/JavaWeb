package com.bookmall.bean;

import java.time.LocalDate;
import java.util.Set;

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
    // 作者列表
    private Set<Author> authors;
    // 出版社
    private Publisher publisher;
    // 出版日期
    private LocalDate time;

    // 构造器
    public Book() {}

    public Book(Integer id, String name, double price, int sales, int stock, String imgPath, Set<Author> authors, Publisher publisher, LocalDate time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
        this.authors = authors;
        this.publisher = publisher;
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public LocalDate getTime() {
        return time;
    }


    public void setTime(LocalDate time) {
        this.time = time;
    }

    /**
     * 用于BeanUtils工具设置 发布日期time
     * 查询数据库Date字段返回对一数据类型为java.sql.Date
     * sql查询语句，查询time列时，需要起别名为sqlTime 或 SqlTime
     *
     * 如果重载setTime，BeanUtils工具赋值JavaBean时失败，
     * 报异常：java.sql.SQLException: Cannot set time: incompatible types, cannot convert java.sql.Date to java.time.LocalDate Query: SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE `name` LIKE ?; Parameters: [%双%]
     * @param date
     */
    public void setSqlTime(java.sql.Date date) {
        LocalDate localDate = date.toLocalDate();
        setTime(localDate);
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
                ", publisher=" + publisher +
                ", time=" + time +
                '}';
    }
}
