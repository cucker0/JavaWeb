package com.bookmall.bean;

import java.math.BigDecimal;

/**
 * 购物车商品
 */
public class CartGoods {
    private int id;
    private String name;
    // 数量
    private int count;
    private BigDecimal price;
    // 是否选中
    private boolean isChecked = false;

    // 构造器
    public CartGoods() {}

    public CartGoods(int id, String name, int count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public CartGoods(int id, String name, int count, double price) {
        this(id, name, count, new BigDecimal("" + price));
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // 获取总价
    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(count));
    }

    @Override
    public String toString() {
        return "CartGoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
