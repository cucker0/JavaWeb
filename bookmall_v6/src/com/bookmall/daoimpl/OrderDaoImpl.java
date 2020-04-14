package com.bookmall.daoimpl;

import com.bookmall.bean.Order;
import com.bookmall.dao.BaseDao;
import com.bookmall.dao.OrderDao;

import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    /**
     * 保存订单
     *
     * @param order 订单对象
     */
    @Override
    public Integer saveOrder(Order order) {
        String sql = "INSERT INTO t_order (id, user_id, total_amount, `status`, create_time) VALUES (?, ?, ?, ?, ?);";
        return insert(sql, order.getId(), order.getUserId(), order.getTotalAmount(), order.getStatus(), order.getCreateTime());
    }

    /**
     * 通过订单id查询订单
     *
     * @param orderId 订单id
     * @return 返回查询到的订单对象
     */
    @Override
    public Order queryOrderById(String orderId) {
        String sql = "SELECT id, user_id userId, total_amount totalAmount, `status`, create_time sqlCreateTime FROM t_order WHERE id = ?;";
        return getBean(sql, orderId);
    }

    /**
     * 查询指定id用户的所有订单
     *
     * @param userId 用户id
     * @return 查询到的订单组合成的List对象
     */
    @Override
    public List<Order> queyrOrdersByUserId(int userId) {
        String sql = "SELECT id, user_id userId, total_amount totalAmount, `status`, create_time sqlCreateTime FROM t_order WHERE user_id = ?;";
        return getBeanList(sql, userId);
    }
}