<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div>
        <span>欢迎
            <span class="um_span">
                <%= request.getAttribute("username") == null ? "韩总" : request.getAttribute("username") %>
            </span>
            光临尚硅谷书城
        </span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
