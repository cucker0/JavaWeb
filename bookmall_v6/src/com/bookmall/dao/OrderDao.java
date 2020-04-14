package com.bookmall.dao;

import com.bookmall.bean.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 保存订单
     *
     * @param order 订单对象
     * @return 返回插入订单记录的id值
     */
    Integer saveOrder(Order order);

    /**
     * 通过订单id查询订单
     *
     * @param orderId 订单id
     * @return 返回查询到的订单对象
     */
    Order queryOrderById(String orderId);

    /**
     * 查询指定id用户的所有订单
     *
     * @param userId 用户id
     * @return 查询到的订单组合成的List对象
     */
    List<Order> queryOrdersByUserId(int userId);

    /**
     * 修改指定id订单的物流状态
     *
     * @param orderId 订单id
     * @param status 物流状态值
     *               0:未发货
     *               1:已发货
     *               2:用户已签收
     */
    void updateOrderStatus(String orderId, int status);
}