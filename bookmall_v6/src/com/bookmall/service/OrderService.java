package com.bookmall.service;

import com.bookmall.bean.Cart;
import com.bookmall.bean.Order;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param cart 购物车对象
     * @param userId 用户id
     * @return 返回订单id
     */
    String addOrder(Cart cart, int userId);

    /**
     * 通过订单id查询订单
     *
     * @param orderId
     * @return
     */
    Order queryOrderById(String orderId);

    /**
     * 查询指定id用户的所有订单
     *
     * @param userId
     * @return
     */
    List<Order> queyrOrdersByUserId(int userId);
}
