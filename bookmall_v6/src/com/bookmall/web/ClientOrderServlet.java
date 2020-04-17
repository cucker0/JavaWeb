package com.bookmall.web;

import com.bookmall.bean.*;
import com.bookmall.service.OrderService;
import com.bookmall.serviceimpl.OrderServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
            // response.sendRedirect(request.getHeader("referer"));
            response.sendRedirect(request.getContextPath() + "/pages/order/orders.jsp");
            return;
        }
        request.setAttribute("orderId", orderId);
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
    }

    protected void updateOrderPayStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // 列出指定用户的所有订单
    protected void pageOrderByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activePageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 10);
        User user = (User) request.getSession().getAttribute("user");
        Paginator<Order> orderPaginator = orderService.pageByUserId(activePageNo, pageSize, user.getId());
        request.setAttribute("page", orderPaginator);
        request.getRequestDispatcher("/pages/order/orders.jsp").forward(request, response);
    }

    // 支付订单
    protected void payOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId").strip();
        Order order = orderService.queryOrderById(orderId);
        // 更新订单的支付状态
        if (order != null) {
            orderService.updateOrderPayStatus(order.getId(), 1);
        }
        // response.sendRedirect(request.getContextPath() + "/client/orderServlet?action=pageOrderByUserId");
        response.sendRedirect(request.getHeader("referer"));
    }

    // 查询指定的订单详情
    protected void getOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId").strip();
        List<OrderItem> orderItems = orderService.queryOrderItemsById(orderId);
        request.setAttribute("orderItems", orderItems);
        Order order = orderService.queryOrderById(orderId);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }
}
