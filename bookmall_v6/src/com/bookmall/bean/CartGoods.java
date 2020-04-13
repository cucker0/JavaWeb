package com.bookmall.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车商品
 */
public class CartGoods implements Serializable {
    private int id;
    private String name;
    private BigDecimal price;
    // 该商品数量
    private int count;
    // 是否选中
    private boolean isChecked = true;

    // 构造器
    public CartGoods() {}

    public CartGoods(int id, String name, BigDecimal price, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public CartGoods(int id, String name, double price, int count) {
        this(id, name, new BigDecimal(Double.toString(price)), count);
    }

    public CartGoods(int id, String name, BigDecimal price, int count, boolean isChecked) {
        this(id, name, price, count);
        this.isChecked = isChecked;
    }

    public CartGoods(int id, String name, double price, int count, boolean isChecked) {
        this(id, name, new BigDecimal(Double.toString(price)), count);
        this.isChecked  = isChecked;
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
        if (count < 0) {
            return;
        }
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    // 获取小计总价
    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(count));
    }

    // 商品数量增加
    public void countIncrease(int num) {
        if (num > 0) {
            count += num;
        }
    }

    @Override
    public String toString() {
        return "CartGoods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", isChecked=" + isChecked +
                '}';
    }
}
