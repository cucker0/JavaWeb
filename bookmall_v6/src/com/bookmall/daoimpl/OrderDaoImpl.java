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
        if ( order.getCreateTime() == null ) {
            String sql = "INSERT INTO t_order (id, user_id, total_amount, `status`, pay_status) VALUES (?, ?, ?, ?, ?);";
            return insert(sql, order.getId(), order.getUserId(), order.getTotalAmount(), order.getStatus(), order.getPayStatus());
        }
        String sql = "INSERT INTO t_order (id, user_id, total_amount, `status`, pay_status, create_time) VALUES (?, ?, ?, ?, ?, ?);";
        return insert(sql, order.getId(), order.getUserId(), order.getTotalAmount(), order.getStatus(), order.getPayStatus(), order.getCreateTime());
    }

    /**
     * 通过订单id查询订单
     *
     * @param orderId 订单id
     * @return 返回查询到的订单对象
     */
    @Override
    public Order queryOrderById(String orderId) {
        String sql = "SELECT id, user_id userId, total_amount totalAmount, `status`, pay_status payStatus, create_time sqlCreateTime FROM t_order WHERE id = ?;";
        return getBean(sql, orderId);
    }

    /**
     * 查询指定id用户的所有订单
     *
     * @param userId 用户id
     * @return 查询到的订单组合成的List对象
     */
    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "SELECT id, user_id userId, total_amount totalAmount, `status`, pay_status payStatus, create_time sqlCreateTime FROM t_order WHERE user_id = ?;";
        return getBeanList(sql, userId);
    }

    /**
     * 查询指定id用户的所有订单
     *
     * @param offSet 从哪个第x个开始
     * @param size   查询多少条
     * @param userId 用户id
     * @return
     */
    @Override
    public List<Order> paginationQueryOrdersByUserId(int offSet, int size, int userId) {
        String sql = "SELECT id, user_id userId, total_amount totalAmount, `status`, pay_status payStatus, create_time sqlCreateTime FROM t_order WHERE user_id = ? LIMIT ?, ?;";
        return getBeanList(sql, userId, offSet, size);
    }

    /**
     * 修改指定id订单的物流状态
     *
     * @param orderId 订单id
     * @param status  物流状态值
     *                0:未发货
     *                1:已发货
     *                2:用户已签收
     */
    @Override
    public void updateOrderStatus(String orderId, int status) {
        String sql = "UPDATE t_order SET `status` = ? WHERE id = ?;";
        update(sql, status, orderId);
    }

    /**
     * 修改指定id订单的支付状态
     *
     * @param orderId   订单id
     * @param payStatus 支付状态值
     *                  0:未付款
     *                  1:已支付
     */
    @Override
    public void updateOrderPayStatus(String orderId, int payStatus) {
        String sql = "UPDATE t_order SET pay_status = ? WHERE id = ?;";
        update(sql, payStatus, orderId);
    }

    /**
     * 查询指定id用户的所有订单的总数量
     *
     * @param userId
     * @return
     */
    @Override
    public int queryOrderTotalByUserId(int userId) {
        String sql = "SELECT COUNT(*) FROM t_order WHERE user_id = ?;";
        long count = getValue(sql, userId);
        return (int) count;
    }
}