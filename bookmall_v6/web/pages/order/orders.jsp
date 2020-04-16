<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <title>我的订单</title>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">我的订单</span>
    <%-- 登录成功后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <th>日期</th>
            <th>金额</th>
            <th>物流状态</th>
            <th>支付状态</th>
            <th>详情</th>
        </tr>
        <c:forEach var="order" items="${requestScope.page.items}">
            <tr>
                <td>${order.createTime}</td>
                <td>${order.totalAmount}</td>
                <c:choose>
                    <c:when test="${order.status == 0}">
                        <td>未发货</td>
                    </c:when>
                    <c:when test="${order.status == 1}">
                        <td>已发货</td>
                    </c:when>
                    <c:when test="${order.status == 2}">
                        <td>已签收</td>
                    </c:when>
                    <c:otherwise>
                        <td>未知</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${order.payStatus == 0}">
                        <td>未付款</td>
                    </c:when>
                    <c:when test="${order.payStatus == 1}">
                        <td>已支付</td>
                    </c:when>
                    <c:when test="${order.payStatus == 2}">
                        <td>已取消</td>
                    </c:when>
                    <c:otherwise>
                        <td>未知</td>
                    </c:otherwise>
                </c:choose>
                <td><a href="client/orderServlet?action=getOrderById&orderId=${order.id}">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>
    <%-- 分页导航条 --%>
    <%@ include file="/pages/common/page_navigation.jsp" %>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>