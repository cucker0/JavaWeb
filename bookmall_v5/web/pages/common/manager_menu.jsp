<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div class="menu">
<%--        <a href="pages/manager/book_manager.jsp">图书管理</a>--%>
        <a href="manager/bookServlet?action=listBook">图书管理</a>
        <a href="manager/authorServlet?action=list">作者管理</a>
        <a href="manager/publisherServlet?action=list">出版社管理</a>
        <a href="pages/manager/order_manager.jsp?">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>