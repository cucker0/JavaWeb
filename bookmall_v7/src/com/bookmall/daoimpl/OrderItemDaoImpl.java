package com.bookmall.daoimpl;

import com.bookmall.bean.OrderItem;
import com.bookmall.dao.BaseDao4Transaction;
import com.bookmall.dao.OrderItemDao;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao4Transaction<OrderItem> implements OrderItemDao {
    /**
     * 保存订单项
     *
     * @param orderItem
     */
    @Override
    public Integer saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item (id, order_id, `name`, price, `count`) VALUES (?, ?, ?, ?, ?);";
        return insert(sql, orderItem.getId(), orderItem.getOrderId(), orderItem.getName(), orderItem.getPrice(), orderItem.getCount());
    }

    /**
     * 根据订单id，查询所有与此订单关联的订单项
     *
     * @param orderId 订单id
     * @return 查询到的订单项组成的List对象
     */
    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "SELECT id, order_id orderId, `name`, price, `count` FROM t_order_item WHERE order_id = ?;";
        return getBeanList(sql, orderId);
    }
}
