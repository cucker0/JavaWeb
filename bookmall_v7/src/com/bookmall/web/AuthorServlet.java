package com.bookmall.web;

import com.bookmall.bean.Author;
import com.bookmall.bean.Paginator;
import com.bookmall.service.AuthorService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import com.bookmall.utils.Beanutils;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AuthorServlet extends BaseServlet {
    private AuthorService authorService;

    public AuthorServlet() {
        authorService = new AuthorServiceImpl();
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Author> authors = authorService.queryAllAuthor();
        request.setAttribute("authors", authors);
        // 转发请求到另外的servlet去处理
        request.getRequestDispatcher("/pages/manager/author_manager.jsp").forward(request, response);
    }

    protected void editAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        // 更新作者信息
        if ("update".equalsIgnoreCase(type)) {
            int authorId = CommonUtils.parseInt(request.getParameter("id"), 0);
            Author author = authorService.queryAuthorById(authorId);
            request.setAttribute("author", author);
        }

        // 新增、更新作者
        request.getRequestDispatcher("/pages/manager/author_edit.jsp").forward(request, response);
    }

    protected void addAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Author author = Beanutils.copyParams2Bean(request.getParameterMap(), new Author());
        authorService.saveAuthor(author);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 3);
        response.sendRedirect(request.getContextPath() + "/manager/authorServlet?action=page" +
                "&page_no=0" +
                "&page_size=" + pageSize);
    }

    protected void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = CommonUtils.parseInt(request.getParameter("id"), 0);
        authorService.deleteAuthorById(authorId);
        int pageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 3);
        response.sendRedirect(request.getContextPath() + "/manager/authorServlet?action=page" +
                "&page_no=" + pageNo +
                "&page_size=" + pageSize);
    }

    protected void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 3);
        Author author = Beanutils.copyParams2Bean(request.getParameterMap(), new Author());
        authorService.updateAuthor(author);
        response.sendRedirect(request.getContextPath() + "/manager/authorServlet?action=page" +
                "&page_no=" + pageNo +
                "&page_size=" + pageSize);
    }

    // 分页显示
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = CommonUtils.parseInt(request.getParameter("page_no"), 1);
        int pageSize = CommonUtils.parseInt(request.getParameter("page_size"), 10);
        Paginator<Author> page = authorService.page(pageNo, pageSize);
        request.setAttribute("page", page);
        // 转发请求到另外的servlet去处理
        request.getRequestDispatcher("/pages/manager/author_manager.jsp").forward(request, response);
    }
}
