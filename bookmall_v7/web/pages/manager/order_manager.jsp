<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <title>订单管理</title>
    <style type="text/css">
        .order-search {
            margin: 30px auto 0 auto;
            width: 740px;
        }
    </style>
    <script>
        $(function () {
            // 订单搜索
            $(".order-search button:first").click(function () {
                var orderId = $(".order-search input[name=orderId]").val().trim();
                var userId = $(".order-search input[name=userId]").val().trim();
                if (orderId.length > 0) {
                    location.href = "${baseUrl}" + "manager/orderServlet?action=getOrderById&orderId=" + orderId;
                } else if (userId.length > 0) {
                    location.href = "${baseUrl}" + "manager/orderServlet?action=pageOrderByUserId&userId=" + userId;
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <%-- 订单搜索框 --%>
    <div class="order-search">
        <label>
            订单号：<input type="text" name="orderId">
        </label>
        <label>
            用户ID：<input type="text" name="userId" value="${requestScope.searchKey4userId}">
        </label>
        <button class="btn btn-primary">搜索</button>
    </div>

    <table>
        <tr>
            <th>订单号</th>
            <th>用户ID</th>
            <th>日期</th>
            <th>金额</th>
            <th>物流状态</th>
            <th>支付状态</th>
            <th>详情</th>
        </tr>
        <c:forEach var="order" items="${requestScope.page.items}">
            <tr>
                <td>${order.id}</td>
                <td>${order.userId}</td>
                <td>${order.createTime}</td>
                <td>
                    <fmt:formatNumber value="${order.totalAmount}" type="currency" pattern="￥0.00"/>
                </td>
                <c:choose>
                    <c:when test="${order.status == 0}">
                        <td>等待发货</td>
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
                <td><a href="manager/orderServlet?action=getOrderById&orderId=${order.id}">查看详情</a></td>
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