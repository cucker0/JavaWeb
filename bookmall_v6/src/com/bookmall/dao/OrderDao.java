package com.bookmall.dao;

import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;

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
     * 查询指定id用户的所有订单
     *
     * @param offSet 从哪个第x个开始
     * @param size 查询多少条
     * @param userId 用户id
     * @return
     */
    List<Order> paginationQueryOrdersByUserId(int offSet, int size, int userId);

    /**
     * 修改指定id订单的物流状态
     *
     * @param orderId 订单id
     * @param status  物流状态值
     *                0:未发货
     *                1:已发货
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
     * 查询指定id用户的所有订单的总数量
     *
     * @param userId
     * @return
     */
    int queryOrderTotalByUserId(int userId);

    /**
     * 查询所有订单
     *
     * @return 一个由所有订单组成的List对象
     */
    List<Order> queryAllOrders();

    /**
     * 查询所有订单的总数量
     *
     * @return 所有订单的总数量
     */
    int queryOrderTotal();

    /**
     * 分页查询所有订单
     *
     * @param offSet 从哪个第x个开始
     * @param size 查询多少条
     * @return 一个由查询到的订单组成的List对象
     */
    List<Order> paginationQueryOrders(int offSet, int size);
}