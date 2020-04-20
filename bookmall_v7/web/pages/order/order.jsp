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

        .order-head {
            width: 480px;
            /*height: 40px;*/
            padding: 30px 0 0 0;
            margin: 0 auto -30px auto;
        }

        .order-head div:first-child {
            float: left;
            line-height: 40px;
        }

        .order-head div:last-child {
            float: right;
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
            <div class="order-head clearfix">
                <div>
                    订单号：
                    <span>${requestScope.order.id}</span>
                    <span>${requestScope.order.payStatus}</span>
                </div>
                <div>
                    <a href="${header.get("referer")}" type="button" class="btn btn-secondary">
                        返回
                    </a>
                    <c:if test="${requestScope.order.payStatus == 0}">
                        <a href="client/orderServlet?action=payOrder&orderId=${requestScope.order.id}" type="button"
                           class="btn btn-primary">
                            现在买单
                        </a>
                    </c:if>
                </div>
            </div>
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计价格</th>
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