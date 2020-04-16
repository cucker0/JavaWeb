package com.bookmall.service;

import com.bookmall.bean.Cart;
import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;
import com.bookmall.bean.Paginator;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     *
     * @param cart   购物车对象
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

    /**
     * 分页查询查询指定id用户的所有订单
     *
     * @param activePageNo
     * @param pageSize
     * @param userId
     * @return
     */
    public Paginator<Order> pageByUserId(int activePageNo, int pageSize, int userId);

    /**
     * 修改指定id订单的物流状态
     *
     * @param orderId 订单id
     * @param status  物流状态值
     *                0:为发货
     *                1:一发货
     *                2:用户已签收
     */
    void updateOrderStatus(String orderId, int status);

    /**
     * 修改指定id订单的支付状态
     *
     * @param orderId   订单id
     * @param payStatus 支付状态值
     *                  0:未付款
     *                  1:已支付
     */
    void updateOrderPayStatus(String orderId, int payStatus);

    /**
     * 查询指定id订单中所包含的商品
     *
     * @param orderId 订单id
     * @return 一个由多个OrderItem组成的List对象
     */
    List<OrderItem> queryOrderItemsById(String orderId);
}
