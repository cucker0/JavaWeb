package com.bookmall.web;

import com.bookmall.bean.Author;
import com.bookmall.bean.Publisher;
import com.bookmall.service.AuthorService;
import com.bookmall.service.PublisherService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import com.bookmall.serviceimpl.PublisherServiceImpl;
import com.bookmall.utils.Beanutils;
import com.bookmall.utils.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PublisherServlet extends BaseServlet {
    private PublisherService publisherService;

    public PublisherServlet() {
        publisherService = new PublisherServiceImpl();
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Publisher> publishers = publisherService.queryAllPublisher();
        request.setAttribute("publishers", publishers);
        // 转发请求到另外的servlet去处理
        request.getRequestDispatcher("/pages/manager/publisher_manager.jsp").forward(request, response);
    }

    protected void editPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        // 更新作者信息
        if ("update".equalsIgnoreCase(type)) {
            int publisherId = CommonUtils.parseInt(request.getParameter("id"), 0);
            Publisher publisher = publisherService.queryPublisherById(publisherId);
            request.setAttribute("publisher", publisher);
        }

        // 新增、更新作者
        request.getRequestDispatcher("/pages/manager/publisher_edit.jsp").forward(request, response);
    }

    protected void addPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publisher publisher = Beanutils.copyParams2Bean(request.getParameterMap(), new Publisher());
        publisherService.addPublisher(publisher);
        response.sendRedirect(request.getContextPath() + "/manager/publisherServlet?action=list");
    }

    protected void deletePublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int publisherId = CommonUtils.parseInt(request.getParameter("id"), 0);
        publisherService.deletePublisherById(publisherId);
        response.sendRedirect(request.getContextPath() + "/manager/publisherServlet?action=list");
    }

    protected void updatePublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publisher publisher = Beanutils.copyParams2Bean(request.getParameterMap(), new Publisher());
        publisherService.updatePublisher(publisher);
        response.sendRedirect(request.getContextPath() + "/manager/publisherServlet?action=list");
    }

}
