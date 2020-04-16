<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
    <c:choose>
        <c:when test="${not empty requestScope.orderItems}">
            <div class="text-center">
                订单号：
                <span>${requestScope.order.id}</span>
                <span>${requestScope.order.payStatus}</span>
                <a href="${header.get("referer")}" type="button"
                   class="btn">
                    返回
                </a>
                <c:if test="${requestScope.order.payStatus == 0}">
                    <a href="client/orderServlet?action=payOrder&orderId=${requestScope.order.id}" type="button"
                       class="btn btn-primary">
                        现在买单
                    </a>
                </c:if>
            </div>
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>小计价格</td>
                </tr>
                <c:forEach var="orderItem" items="${requestScope.orderItems}">
                    <tr>
                        <td>${orderItem.name}</td>
                        <td><fmt:formatNumber value="${orderItem.price}" type="currency" pattern="￥0.00"/></td>
                        <td>${orderItem.count}</td>
                        <td><fmt:formatNumber value="${orderItem.getTotalPrice()}" type="currency"
                                              pattern="￥0.00"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <div>无此订单！！！</div>
        </c:otherwise>
    </c:choose>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>