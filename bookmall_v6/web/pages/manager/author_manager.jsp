<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <title>作者管理</title>
    <script type="text/javascript">
        $(function () {
            // 给删除按钮绑定事件
            $("a.delete").click(function () {
                var name = $(this).parents("tr").find("td:first").html();
                return confirm("[" + name + "]\n 确定删除吗?");
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
            <th>姓名</th>
            <th class="td-w2">简介</th>
            <th colspan="2">操作</th>
        </tr>

        <c:forEach var="author" items="${requestScope.page.items}">
            <tr>
                <td>${author.name}</td>
                <td>${author.brief}</td>
                <td>
                    <a href="manager/authorServlet?action=editAuthor&type=update&id=${author.id}&page_no=${requestScope.page.activePageNo}&page_size=${requestScope.page.size}">
                        修改
                    </a>
                </td>
                <td>
                    <a class="delete"
                       href="manager/authorServlet?action=deleteAuthor&id=${author.id}&page_no=${requestScope.page.activePageNo}&page_size=${requestScope.page.size}">
                        删除
                    </a>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="manager/authorServlet?action=editAuthor&type=add&page_size=${requestScope.page.size}">添加作者</a></td>
        </tr>
    </table>
    <%@ include file="/pages/common/page_navigation.jsp" %>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>