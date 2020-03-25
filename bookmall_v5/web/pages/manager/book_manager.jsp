<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <title>图书管理</title>
    <script type="text/javascript">
        $(function () {
            // 给删除按钮绑定事件
            $("a.delete").click(function () {
                var name = $(this).parents("tr").find("td:first").html();
                return confirm("《" + name + "》\n 确定删除吗?");
            });
        });
    </script>
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
            <th>书名</th>
            <th>价格</th>
            <th class="td-w">作者</th>
            <th>销量</th>
            <th>库存</th>
            <th colspan="2">操作</th>
        </tr>
        <%-- 遍历图书 --%>
        <%--        <c:forEach var="book" items="${requestScope.books}">--%>
        <c:forEach var="book" items="${requestScope.page.items}">
            <tr>
                <td>${book.name}</td>
                <td>
                    <fmt:formatNumber value="${book.price}" type="currency" pattern="￥.00"/>
                </td>
                <td>
                        <%--                    遍历作者--%>
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
                <td><a href="manager/bookServlet?action=editBook&type=update&id=${book.id}">修改</a></td>
                <td><a class="delete" href="manager/bookServlet?action=deleteBook&id=${book.id}">删除</a></td>
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
    <%-- 分页条导航条 --%>
    <%@ include file="/pages/common/page_navigation.jsp" %>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>