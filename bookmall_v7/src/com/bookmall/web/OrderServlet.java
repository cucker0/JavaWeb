package com.bookmall.web;

import com.bookmall.bean.Order;
import com.bookmall.bean.Paginator;
import com.bookmall.bean.User;
import com.bookmall.dao.Common;
import com.bookmall.service.OrderService;
import com.bookmall.serviceimpl.OrderServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * manager端 OrderServlet
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService;

    public OrderServlet() {
        orderService = new OrderServiceImpl();
    }

    // 分页展示所有订单
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activePageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 10);
        Paginator<Order> page = orderService.page(activePageNo, pageSize);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    // 分页展示指定user id的用户的所有订单
    protected void pageOrderByUserId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activePageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 10);
        int userId = CommonUtils.parseInt(request.getParameter("userId"), 0);
        Paginator<Order> orderPaginator = orderService.pageByUserId(activePageNo, pageSize, userId);
        request.setAttribute("page", orderPaginator);
        request.setAttribute("searchKey4userId", userId);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
    }

    // 通过order id搜索订单
    protected void getOrderById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId").strip();
        Order order = orderService.queryOrderById(orderId);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/pages/manager/order.jsp").forward(request, response);
    }

    // 更新物流状态
    protected void updateOrderStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId").strip();
        int status = CommonUtils.parseInt(request.getParameter("status"), -1);
        if (status == -1) {
            return;
        }
        // 更新指定订单的物流状态
        orderService.updateOrderStatus(orderId, status);
        response.sendRedirect(request.getHeader("referer"));
    }
}
