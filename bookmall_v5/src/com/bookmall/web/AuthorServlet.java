package com.bookmall.web;

import com.bookmall.bean.Author;
import com.bookmall.service.AuthorService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
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

    }

    protected void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
