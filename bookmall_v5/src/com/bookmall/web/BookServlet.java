package com.bookmall.web;

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.bean.Publisher;
import com.bookmall.dao.Common;
import com.bookmall.service.AuthorService;
import com.bookmall.service.BookService;
import com.bookmall.service.PublisherService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.serviceimpl.PublisherServiceImpl;
import com.bookmall.utils.Beanutils;
import com.bookmall.utils.CommonUtils;

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
        // 获取作者列表、出版社列表，并保存到request域对象中
        List<Author> authors = null;
        List<Publisher> publishers = null;
        // 新增图书
        if ("add".equalsIgnoreCase(request.getParameter("type"))) {
            authors = authorService.queryAllAuthor();
            publishers = publisherService.queryAllPublisher();

        }
        // 更新图书
        else if ("update".equalsIgnoreCase(request.getParameter("type"))) {
            int bookId = CommonUtils.parseInt(request.getParameter("id"), 0);
            Book book = bookService.queryBookById(bookId);
            request.setAttribute("book", book);
            authors = authorService.queryAllAuthor(bookId);
            publishers = publisherService.queryAllPublisher(bookId);
        } else {

        }
        // 把数据保存到request域对象中
        request.setAttribute("authors", authors);
        request.setAttribute("publishers", publishers);
        // 转发请求
        // 注意：request对象中有有一个参数type，type预定义的有 add \ update
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取客户端request中传过来的图书信息，并封装到Book对象中
        String[] authorsId = request.getParameterValues("authors_id");
        List<Author> authors = authorService.queryAuthorByIdSet(CommonUtils.strArry2IntegerSet(authorsId, null));
        int publisherId = CommonUtils.parseInt(request.getParameter("publisher_id"), 0);
        Publisher publisher = publisherService.queryPublisherById(publisherId);

        Book book = Beanutils.copyParams2Bean(request.getParameterMap(), new Book());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        //System.out.println("book:" + book);
        // 添加图书
        bookService.addBook(book);

        // 添加完后，URL跳转到图书列表页
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=listBook");
    }

    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = CommonUtils.parseInt(request.getParameter("id"), 0);
        bookService.deleteBookById(bookId);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=listBook");
    }

    protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] authorsId = request.getParameterValues("authors_id");
        List<Author> authors = authorService.queryAuthorByIdSet(CommonUtils.strArry2IntegerSet(authorsId, null));
        int publisherId = CommonUtils.parseInt(request.getParameter("publisher_id"), 0);
        Publisher publisher = publisherService.queryPublisherById(publisherId);
        // book中含有id属性
        Book book = Beanutils.copyParams2Bean(request.getParameterMap(), new Book());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=listBook");
    }

}
