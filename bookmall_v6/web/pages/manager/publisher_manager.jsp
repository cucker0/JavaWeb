<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>出版社管理</title>
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
            <th class="td-w2">出版社名称</th>
            <th colspan="2">操作</th>
        </tr>

        <c:forEach var="publisher" items="${requestScope.publishers}">
            <tr>
                <td>${publisher.name}</td>
                <td><a href="manager/publisherServlet?action=editPublisher&type=update&id=${publisher.id}">修改</a></td>
                <td><a class="delete" href="manager/publisherServlet?action=deletePublisher&id=${publisher.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="manager/publisherServlet?action=editPublisher&type=add">添加出版社</a></td>
        </tr>
    </table>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>