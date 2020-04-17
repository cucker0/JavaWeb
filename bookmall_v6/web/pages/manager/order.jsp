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
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <div style="margin-left: 20px">
        <a type="button" class="btn btn-secondary" href="manager/orderServlet?action=page">返回订单管理</a>
    </div>
    <c:choose>
        <c:when test="${empty requestScope.order}">
            <div class="text-center">无此订单</div>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>日期</th>
                    <th>金额</th>
                    <th>物流状态</th>
                    <th>支付状态</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>${requestScope.order.createTime}</td>
                    <td>
                        <fmt:formatNumber value="${requestScope.order.totalAmount}" type="currency" pattern="￥0.00"/>
                    </td>
                    <c:choose>
                        <c:when test="${requestScope.order.status == 0}">
                            <td>等待发货</td>
                        </c:when>
                        <c:when test="${requestScope.order.status == 1}">
                            <td>已发货</td>
                        </c:when>
                        <c:when test="${requestScope.order.status == 2}">
                            <td>已签收</td>
                        </c:when>
                        <c:otherwise>
                            <td>未知</td>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${requestScope.order.payStatus == 0}">
                            <td>未付款</td>
                        </c:when>
                        <c:when test="${requestScope.order.payStatus == 1}">
                            <td>已支付</td>
                        </c:when>
                        <c:when test="${requestScope.order.payStatus == 2}">
                            <td>已取消</td>
                        </c:when>
                        <c:otherwise>
                            <td>未知</td>
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <c:choose>
                            <c:when test="${requestScope.order.status == 0}">
                                <a href="manager/orderServlet?action=updateOrderStatus&status=1&orderId=${requestScope.order.id}">发货</a>
                                <a href="manager/orderServlet?action=updateOrderStatus&status=2&orderId=${requestScope.order.id}">签收</a>
                            </c:when>
                            <c:when test="${requestScope.order.status == 1}">
                                <a href="manager/orderServlet?action=updateOrderStatus&status=2&orderId=${requestScope.order.id}">签收</a>
                            </c:when>
                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>
            </table>
            <%-- 分页导航条 --%>
            <%@ include file="/pages/common/page_navigation.jsp" %>
        </c:otherwise>
    </c:choose>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>