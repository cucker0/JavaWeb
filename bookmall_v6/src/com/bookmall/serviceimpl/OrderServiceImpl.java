package com.bookmall.serviceimpl;

import com.bookmall.bean.*;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.OrderDao;
import com.bookmall.dao.OrderItemDao;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.daoimpl.OrderDaoImpl;
import com.bookmall.daoimpl.OrderItemDaoImpl;
import com.bookmall.service.OrderService;
import com.bookmall.utils.CommonUtils;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderItemDao orderItemDao;
    private BookDao bookDao;

    public OrderServiceImpl() {
        orderDao = new OrderDaoImpl();
        orderItemDao = new OrderItemDaoImpl();
        bookDao = new BookDaoImpl();
    }

    /**
     * 创建订单
     *
     * @param cart   购物车对象
     * @param userId 用户id
     * @return 返回订单id
     */
    @Override
    public String addOrder(Cart cart, int userId) {
        // 保存订单
        // 生成订单id：当前时间 + "_" + 用户id
        // String orderId = System.currentTimeMillis() + "_" + userId;
        String orderId = CommonUtils.generateOrderId(userId);
        Order order = new Order(orderId, userId, cart.getTotalPrice(), 0, null);
        orderDao.saveOrder(order);

        // 生成订单项，由购物车中的商品情况决定
        for (CartGoods g : cart.getAllCheckedGoods()) {
            OrderItem orderItem = new OrderItem(null, orderId, g.getName(), g.getPrice(), g.getCount());
            orderItemDao.saveOrderItem(orderItem);
            // 调整商品的销量、库存
            Book book = bookDao.queryBookById(g.getId());
            book.salesIncrease(g.getCount());
            book.stockDecrease(g.getCount());
            bookDao.updateBook(book);
        }
        // 删除购物车中已经付款的商品
        cart.removeCheckedGoods();
        return orderId;
    }

    /**
     * 通过订单id查询订单
     *
     * @param orderId
     * @return
     */
    @Override
    public Order queryOrderById(String orderId) {
        return orderDao.queryOrderById(orderId);
    }

    /**
     * 查询指定id用户的所有订单
     *
     * @param userId
     * @return
     */
    @Override
    public List<Order> queyrOrdersByUserId(int userId) {
        return orderDao.queryOrdersByUserId(userId);
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
        orderDao.updateOrderStatus(orderId, status);
    }
}
