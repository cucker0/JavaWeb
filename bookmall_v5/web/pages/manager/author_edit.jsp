<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>编辑作者</title>
    <style type="text/css">
        #main {
            width: 90%;
        }
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            padding: 5px;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑作者</span>
    <%-- 管理模块菜单 --%>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <c:choose>
        <%-- 添加作者 --%>
        <c:when test="${param.type == 'add'}">
            <form action="manager/authorServlet" method="post">
                <input type="hidden" name="action" value="addAuthor">
                <table>
                    <thead>
                        <th>姓名</th>
                        <th class="td-w2">简介</th>
                        <th>操作</th>
                    </thead>
                    <tr>
                        <td><input name="name" type="text"/></td>
                        <td><input name="brief" type="text"/></td>
                        <td><input type="submit" value="提交"/></td>
                    </tr>
                </table>
            </form>
        </c:when>
        <%-- 更新作者 --%>
        <c:when test="${param.type == 'update'}">
            <form action="manager/authorServlet" method="post">
                <input type="hidden" name="action" value="updateAuthor">
                <input type="hidden" name="id" value="${requestScope.author.id}">
                <table>
                    <thead>
                    <th>姓名</th>
                    <th>简介</th>
                    <th>操作</th>
                    </thead>
                    <tr>
                        <td><input name="name" type="text" value="${requestScope.author.name}"/></td>
                        <td><input name="brief" type="text" value="${requestScope.author.brief}"/></td>
                        <td><input type="submit" value="提交"/></td>
                    </tr>
                </table>
            </form>
        </c:when>
    </c:choose>


</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>