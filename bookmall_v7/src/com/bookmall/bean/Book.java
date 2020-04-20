package com.bookmall.bean;

import java.time.LocalDate;
import java.time.LocalTime;
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
    // 作者列表
    private List<Author> authors;
    // 出版社
    private Publisher publisher;
    // 出版日期
    private LocalDate time;

    // 构造器
    public Book() {}

    public Book(Integer id, String name, double price, int sales, int stock, String imgPath, List<Author> authors, Publisher publisher, LocalDate time) {
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
        if (name == null) {
            return;
        }
        name = name.strip();
        if (name.length() == 0) {
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            return;
        }
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        if (sales < 0) {
            return;
        }
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            return;
        }
        this.stock = stock;
    }

    public String getImgPath() {
        if (imgPath == null) {
            return "static/img/default.jpg";
        }
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            return;
        }
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        if (publisher == null) {
            return;
        }
        this.publisher = publisher;
    }

    /**
     * 给Publisher设置出版社ID
     *
     * 主要用于从数据库查询book数据时用，
     * 注意sql查询publisher_id列，起别名:publisherId
     *
     * @param publisherId
     */
    public void setPublisherId(int publisherId) {
        if (publisherId < 0) {
            return;
        }
        Publisher publisher = new Publisher(publisherId, null);
        setPublisher(publisher);
    }

    public LocalDate getTime() {
        return time;
    }


    public void setTime(LocalDate time) {
        if (time == null) {
            return;
        }
        this.time = time;
    }

    /**
     * 用于BeanUtils工具设置 发布日期time
     * 查询数据库Date字段返回对一数据类型为java.sql.Date
     * sql查询语句，查询time列时，需要起别名为:sqlTime 或 SqlTime
     *
     * 如果重载setTime，BeanUtils工具赋值JavaBean时失败，
     * 报异常：java.sql.SQLException: Cannot set time: incompatible types, cannot convert java.sql.Date to java.time.LocalDate Query: SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE `name` LIKE ?; Parameters: [%双%]
     * @param date
     */
    public void setSqlTime(java.sql.Date date) {
        if (date == null) {
            return;
        }
        LocalDate localDate = date.toLocalDate();
        setTime(localDate);
    }

    // 解决BeanUtils处理JavaBean时问题： 客户端传过来的文本日期，而time期望为LocalDate类型数据
    // 注意：客户端页面的<input name="sqlTime">
    public void setSqlTime(String dateStr) {
        LocalDate localDate = LocalDate.parse(dateStr);
        setTime(localDate);
    }

    /**
     * 卖出商品后，增加销量
     *
     * 通过DAO先从数据库查询数据获得book对象，再调整销量
     *
     * @param count 卖出的图书数量
     * @return 销量是否调整了
     *      true: 调整了
     *      false: 未调整
     */
    public boolean salesIncrease(int count) {
        if (getId() == null) { // 因为通过DAO先从数据库查询数据获得book对象，再调整销量
            return false;
        }
        if (count <= 0) {
            return false;
        }
        int salesNew = getSales() + count;
        setSales(salesNew);
        return true;
    }

    /**
     * 卖出商品后，减少库存
     *
     * 通过DAO先从数据库查询数据获得book对象，再调整库存量
     *
     * @param count 卖出的图书数量
     * @return 库存是否调整了
     *      true: 调整了
     *      false: 未调整
     */
    public boolean stockDecrease(int count) {
        if (getId() == null) { // 因为通过DAO先从数据库查询数据获得book对象，再调整销量
            return false;
        }
        if (count <= 0 || count > getStock()) {
            return false;
        }
        int stockNew = getStock() - count;
        setStock(stockNew);
        return true;
    }

    /**
     * 图书进货了，增加库存量
     *
     * @param count 进货的图书数量
     * @return 库存是否调整了
     *      true: 调整了
     *      false: 未调整
     */
    public boolean stockIncrease(int count) {
        if (getId() == null) { // 因为通过DAO先从数据库查询数据获得book对象，再调整销量
            return false;
        }
        if (count <= 0) {
            return false;
        }
        int stockNew = getStock() + count;
        setStock(stockNew);
        return true;
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
