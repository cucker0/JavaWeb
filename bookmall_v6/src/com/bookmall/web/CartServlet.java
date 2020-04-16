package com.bookmall.web;

import com.bookmall.bean.Book;
import com.bookmall.bean.Cart;
import com.bookmall.bean.CartGoods;
import com.bookmall.service.BookService;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class CartServlet extends BaseServlet {
    private BookService bookService;

    public CartServlet() {
        bookService = new BookServiceImpl();
    }

    // 添加商品到购物车
    protected void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过图书id查询图书
        int bookId = CommonUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        // 把图书添加到购物车
        Cart cart = CommonUtils.getCart(request, response);
        if ( book != null ) {
            // 图书信息转换成 CartGoods对象
            cart.addGoods(new CartGoods(book.getId(), book.getName(), book.getPrice(), 1));
            // 更新添加到购物车的最后一件商品信息到session域对象中
            request.getSession().setAttribute("lastGoodsName", book.getName());
            // long now = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
            // OffsetDateTime.now().getOffset(): 获取系统默认的ZoneOffset
            long now = LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset());
            request.getSession().setAttribute("lastAddgoodsTime", now);
        }
        // System.out.println("request head中的refere: " + request.getHeader("referer"));
        // 重定向到客户刚刚访问的页面
        response.sendRedirect(request.getHeader("referer"));
    }

    // // 获取购物车，没有则创建
    // protected Cart getCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     Cart cart = (Cart) request.getSession().getAttribute("cart");
    //     if ( cart == null ) {
    //         cart = new Cart();
    //         HttpSession session = request.getSession();
    //         session.setAttribute("cart", cart);
    //         Cookie ck = new Cookie("JSESSIONID", session.getId());
    //         ck.setMaxAge(60 * 60 * 24 * 5);
    //         response.addCookie(ck);
    //     }
    //     return cart;
    // }

    // 删除购物车中指定的商品
    protected void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = CommonUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = CommonUtils.getCart(request, response);
        cart.deleteGoods(goodsId);
        response.sendRedirect(request.getHeader("referer"));
    }

    // 修改购物车中指定商品的数量
    protected void updateGoodsCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = CommonUtils.parseInt(request.getParameter("id"), 0);
        int count = CommonUtils.parseInt(request.getParameter("count"), 0);
        Cart cart = CommonUtils.getCart(request, response);
        cart.updateGoods(goodsId, count);
        response.sendRedirect(request.getHeader("referer"));
    }

    // 清空购物车
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = CommonUtils.getCart(request, response);
        cart.clear();
        response.sendRedirect(request.getHeader("referer"));
    }

    // 全选 / 取消 购物车所有商品
    protected void checkedAllOrNot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = CommonUtils.getCart(request, response);
        cart.checkedAllOrNot();
        response.sendRedirect(request.getHeader("referer"));

    }

    // 选择 / 取消 购物车中指定商品
    protected void checkedGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = CommonUtils.parseInt(request.getParameter("id"), 0);
        boolean checked = CommonUtils.parseBoolean(request.getParameter("checked"), false);
        Cart cart = CommonUtils.getCart(request, response);
        cart.checkedGoods(goodsId, checked);
        response.sendRedirect(request.getHeader("referer"));
    }
}
