package com.bookmall.web;

import com.bookmall.bean.Cart;
import com.bookmall.bean.Order;
import com.bookmall.bean.User;
import com.bookmall.service.OrderService;
import com.bookmall.serviceimpl.OrderServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientOrderServlet extends BaseServlet {
    private OrderService orderService;

    public ClientOrderServlet() {
        orderService = new OrderServiceImpl();
    }

    // 准备付款，创建order订单
    protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 对购物车中的商品进行买单需要用户登录
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
            return;
        }
        Cart cart = CommonUtils.getCart(request, response);
        String orderId = orderService.addOrder(cart, user.getId());
        if (orderId == null) {
            response.sendRedirect(request.getHeader("referer"));
            return;
        }
        request.setAttribute("orderId", orderId);
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
    }

    // 支付订单
    protected void payOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId").strip();
        Order order = orderService.queryOrderById(orderId);
        // 更新订单的支付状态
        if (order != null) {
            orderService.updateOrderPayStatus(order.getId(), 1);
        }
        response.sendRedirect(request.getContextPath() + "/pages/order/order.jsp");
    }
}
