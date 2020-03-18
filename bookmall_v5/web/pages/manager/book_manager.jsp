<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>图书管理</title>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td class="td-w">作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach var="book" items="${requestScope.books}">
            <tr>
                <td>${book.name}</td>
                <td>
                    <fmt:formatNumber value="${book.price}" type="currency" pattern="￥.00"/>
                </td>
                <td>
<%--                    遍历图书--%>
                    <c:forEach var="author" items="${book.authors}" varStatus="status">
                        <c:choose>
                            <c:when test="${status.last}">
                                ${author["name"]}
                            </c:when>
                            <c:otherwise>
                                ${author["name"]} |
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=updateBook">修改</a></td>
                <td><a href="#">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="manager/bookServlet?action=editBook&type=add">添加图书</a></td>
        </tr>
    </table>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>