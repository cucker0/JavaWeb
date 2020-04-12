package com.bookmall.web;

import com.bookmall.bean.Book;
import com.bookmall.bean.Cart;
import com.bookmall.service.BookService;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    private BookService bookService;

    public CartServlet() {
        bookService = new BookServiceImpl();
    }

    // 添加商品到购物车
    protected void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = CommonUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        Cart cart = getCart(request, response);

    }

    /**
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    // // 获取购物车，没有则创建
    protected Cart getCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            HttpSession session = request.getSession();
            session.setAttribute("cart", cart);
            if (session.isNew()) {
                Cookie ck = new Cookie("JSESSIONID", session.getId());
                ck.setMaxAge(60 * 60 * 24 * 5);
                response.addCookie(ck);
            }
        }
        return cart;
    }

}
