package com.bookmall.bean;

import java.math.BigDecimal;

public class OrderItem {
    private Long id;
    // 订单项关联的订单id
    private String orderId;
    // 商品名称
    private String name;
    // 商品单价
    private BigDecimal price;
    // 商品数量
    private int count;

    // 构造器
    public OrderItem() {
    }

    public OrderItem(Long id, String orderId, String name, BigDecimal price, int count) {
        setId(id);
        setOrderId(orderId);
        setName(name);
        setPrice(price);
        setCount(count);
    }

    public OrderItem(Long id, String orderId, String name, Double price, int count) {
        this(id, orderId, name, new BigDecimal(price.toString()), count);
    }

    // 方法

    /**
     * 计算此订单项(商品)的小计总价
     *
     * @return
     */
    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(count));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", TotalPrice" + getTotalPrice() +
                '}';
    }
}
