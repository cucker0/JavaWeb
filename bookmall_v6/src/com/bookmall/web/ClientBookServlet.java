package com.bookmall.web;

import com.bookmall.bean.Book;
import com.bookmall.bean.Paginator;
import com.bookmall.service.BookService;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activePageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        // int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 3);
        int pageSize = 4;
        double minPrice = CommonUtils.parseDouble(request.getParameter("min_price"), -1);
        double maxPrice = CommonUtils.parseDouble(request.getParameter("max_price"), -1);
        // 分页查询图书
        Paginator<Book> page = null;
        if (minPrice >= 0 && minPrice < maxPrice) {
            page = bookService.pageByPrice(activePageNo, pageSize, minPrice, maxPrice);
        } else {
            page = bookService.page(activePageNo, pageSize);
        }
        page.setUrl("client/clientBookServlet?action=page");
        request.setAttribute("page", page);
        // 转发请求
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
