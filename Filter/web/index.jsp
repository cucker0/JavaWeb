<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/common/head.jsp" %>
    <title>Filter测试</title>
</head>
<body>
<h3>
    filter
</h3>

<div>
    <div>
        <a href="admin/user_center.jsp">admin目录下的user_center.jsp</a>
    </div>
    <div>
        <a href="admin/manager.html">admin目录下的manger.html</a>
    </div>
    <div>
        <a href="admin/img/ch0.png">admin目录下的图片</a>
    </div>
</div>
<br><br>
<div>
    <a href="transaction/recharge.jsp">充值系统</a>
</div>
<br><br>
<div>
    <a href="filterChain.jsp">同一URL匹配模式应用多个Filter</a>
</div>

<br><br>
<div>
    Filter url-pattern匹配模式
    <ul>
        <li>
            <a href="static/css/common.css">/static/css/common.css</a>
        </li>
        <li>
            <a href="pages/a.html">/pages/a.html</a>
        </li>
        <li>
            <a href="pages/b.html">/pages/b.html</a>
        </li>
        <li>
            <a href="info/xx.html">/info/xx.html</a>
        </li>
        <li>
            <a href="kk">/kk</a>
        </li>
    </ul>

</div>
</body>
</html>
