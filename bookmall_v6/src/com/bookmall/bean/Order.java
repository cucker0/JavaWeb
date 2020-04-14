package com.bookmall.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    // 订单id
    private String id;
    // 订单关联的用户id
    private int userId;
    // 此订单的总金额
    private BigDecimal totalAmount;
    // 订单的物流状态，0:为发货  1:一发货  2:用户已签收
    private int status;
    // 订单创建时间
    private LocalDateTime createTime;

    // 构造器
    public Order() {}

    public Order(String id, int userId, BigDecimal totalAmount, int status, LocalDateTime createTime) {
        this.id = id;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createTime = createTime;
    }

    public Order(String id, int userId, Double totalAmount, int status, LocalDateTime createTime) {
        this(id, userId, new BigDecimal(totalAmount.toString()), status, createTime);
    }

    // 方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 用于BeanUtils工具设置 createTime
     * sql查询语句，查询createTime列时，需要起别名为:sqlCreateTime 或 SqlCreateTime
     *
     * @param timestamp
     */
    public void setSqlCreateTime(java.sql.Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        setCreateTime(localDateTime);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
