<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <title>结算页面</title>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">结算</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="">返回</a>
    </div>
</div>

<div id="main">
    <h1>你的订单已结算，订单号：${requestScope.orderId}</h1>
    <div class="pay_option">
        <a href="${header.get("refere")}" type="button" class="btn btn-secondary">再逛逛</a>
        <a href="client/orderServlet?action=payOrder&orderId=${requestScope.orderId}" type="button"
           class="btn btn-primary">现在支付</a>
    </div>
</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>