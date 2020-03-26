<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>编辑图书</title>
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

        form input[type=submit] {
            float: right;
            margin: 33px 82px 0 0;
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

<div id="main" class="clearfix">
    <c:choose>
        <%-- 添加图书 --%>
        <c:when test="${param.type == 'add'}">
            <form action="manager/bookServlet" method="post">
                <input type="hidden" name="action" value="addBook">
                <table>
                    <tr>
                        <td>书名</td>
                        <td>价格(￥)</td>
                        <td>作者</td>
                        <td>销量</td>
                        <td>库存</td>
                        <td>出版社</td>
                        <td>出版日期</td>
                        <td>图片路径</td>
                    </tr>
                    <tr>
                        <td><input name="name" type="text"/></td>
                        <td><input name="price" type="text"/></td>
                            <%--                <td><input name="author" type="text" value="霍金"/></td>--%>
                        <td>
                            <select name="authors_id" multiple="multiple">
                                <option>选择作者</option>
                                <c:forEach var="author" items="${requestScope.authors}">
                                    <option value="${author.id}">${author.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input name="sales" type="text" /></td>
                        <td><input name="stock" type="text" /></td>
                        <td>
                            <select name="publisher_id">
                                <option>请选择出版社</option>
                                <c:forEach var="publisher" items="${requestScope.publishers}">
                                    <option value="${publisher.id}">${publisher.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input name="sqlTime" type="text"></td>
                        <td><input name="imgPath" type="text"></td>
                    </tr>
                </table>
                <input type="submit" value="提交"/>
            </form>
        </c:when>
        <%-- 更新图书 --%>
        <c:when test="${param.type == 'update'}">
            <form action="manager/bookServlet" method="post">
                <input type="hidden" name="action" value="updateBook">
                <input type="hidden" name="id" value="${requestScope.book.id}">
                <input type="hidden" name="page_no" value="${requestScope.pageNo}">
                <input type="hidden" name="page_size" value="${requestScope.pageSize}">
                <table>
                    <tr>
                        <td>书名</td>
                        <td>价格(￥)</td>
                        <td>作者</td>
                        <td>销量</td>
                        <td>库存</td>
                        <td>出版社</td>
                        <td>出版日期</td>
                        <td>图片路径</td>
                    </tr>
                    <tr>
                        <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                        <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                            <%--                <td><input name="author" type="text" value="霍金"/></td>--%>
                        <td>
                            <select name="authors_id" multiple="multiple">
                                <option>选择作者</option>
                                <c:forEach var="author" items="${requestScope.authors}">
                                    <c:choose>
                                        <c:when test="${author.checked}">
                                            <option value="${author.id}" selected="selected">${author.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${author.id}">${author.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                        <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                        <td>
                            <select name="publisher_id">
                                <option>请选择出版社</option>
                                <c:forEach var="publisher" items="${requestScope.publishers}">
                                    <c:choose>
                                        <c:when test="${publisher.checked}">
                                            <option value="${publisher.id}" selected="selected">${publisher.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${publisher.id}">${publisher.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input name="sqlTime" type="text" value="${book.time}"></td>
                        <td><input name="imgPath" type="text" value="${book.imgPath}"></td>
                    </tr>
                </table>
                <input type="submit" value="提交"/>
            </form>
        </c:when>
    </c:choose>


</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>