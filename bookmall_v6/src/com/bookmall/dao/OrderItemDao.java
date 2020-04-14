package com.bookmall.dao;

import com.bookmall.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    /**
     * 保存订单项
     *
     * @param orderItem
     */
    Integer saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单id，查询所有与此订单关联的订单项
     *
     * @param orderId 订单id
     * @return 查询到的订单项组成的List对象
     */
    List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
