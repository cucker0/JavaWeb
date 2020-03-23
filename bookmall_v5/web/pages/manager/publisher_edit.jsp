<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>编辑出版社</title>
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
    <span class="wel_word">编辑出版社</span>
    <%-- 管理模块菜单 --%>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <c:choose>
        <%-- 添加出版社 --%>
        <c:when test="${param.type == 'add'}">
            <form action="manager/publisherServlet" method="post">
                <input type="hidden" name="action" value="addPublisher">
                <table>
                    <tr>
                        <td class="td-w2">出版社名称</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td><input class="input-w" name="name" type="text"/></td>
                        <td><input type="submit" value="提交"/></td>
                    </tr>
                </table>
            </form>
        </c:when>
        <%-- 更新出版社 --%>
        <c:when test="${param.type == 'update'}">
            <form action="manager/publisherServlet" method="post">
                <input type="hidden" name="action" value="updatePublisher">
                <input type="hidden" name="id" value="${requestScope.publisher.id}">
                <table>
                    <tr>
                    <td class="td-w2">出版社名称</td>
                    <td>操作</td>
                    </tr>
                    <tr>
                        <td><input class="input-w" name="name" type="text" value="${requestScope.publisher.name}"/></td>
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