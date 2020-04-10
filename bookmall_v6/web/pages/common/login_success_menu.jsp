<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <div>
        <span>欢迎
            <span class="um_span">
                ${sessionScope.user.username}
            </span>
            光临尚硅谷书城
        </span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="">返回首页</a>
    </div>
