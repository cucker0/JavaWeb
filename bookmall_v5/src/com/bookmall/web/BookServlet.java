package com.bookmall.web;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.bean.Publisher;
import com.bookmall.service.AuthorService;
import com.bookmall.service.BookService;
import com.bookmall.service.PublisherService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.serviceimpl.PublisherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService;
    private AuthorService authorService = new AuthorServiceImpl();
    private PublisherService publisherService = new PublisherServiceImpl();

    public BookServlet() {
        bookService = new BookServiceImpl();
    }

    // 业务逻辑方法
    protected void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 查询所有的图书数据，并保存到Request域对象中
        List<Book> books = bookService.queryAllBook();
        request.setAttribute("books", books);
        // 2. 把request请求转发到pages/manager/book_manager.jsp对应的jsp页面去处理(jsp本质就是Servlet)
        // request转发中，/ 表示 http://ip:port/工程名
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 新增、或更新图书时的编辑页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取业务类型，从request获取type参数
        String type = request.getParameter("type");

        // 2. 根据type转发请求，type预定义的有 add \ update
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?action=" + type).forward(request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取作者列表、出版社列表，并保存到request域对象中
        List<Author> authors = authorService.queryAllAuthor();
        request.setAttribute("authors", authors);
        List<Publisher> publishers = publisherService.queryAllPublisher();
        request.setAttribute("publishers", publishers);

        // 2. 转发请求
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?action=add").forward(request, response);
    }

}
