<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>编辑图书</title>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">编辑图书</span>
    <%-- 管理模块菜单 --%>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <form action="addBook">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td>出版社</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="时间简史"/></td>
                <td><input name="price" type="text" value="30.00"/></td>
<%--                <td><input name="author" type="text" value="霍金"/></td>--%>
                <td>
                    <select name="authors_id" multiple="multiple">
                        <option>选择作者</option>
                        <c:forEach var="author" items="${requestScope.authors}">
                            <option value="${author.id}">${author.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input name="sales" type="text" value="200"/></td>
                <td><input name="stock" type="text" value="300"/></td>
                <td>
                    <select name="publisher_id">
                        <option>请选择出版社</option>
                        <c:forEach var="publisher" items="${requestScope.publishers}">
                            <option value="${publisher.id}">${publisher.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>