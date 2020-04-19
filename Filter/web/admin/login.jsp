<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/admin/common/head.jsp" %>
    <title>登录管理系统</title>
</head>
<body>
<div>
    <form action="login" method="post">
        <div>
            <label>
                用户名：<input type="text" name="username">
            </label>
        </div>
        <div>
            <label>
                密码：<input type="password" name="password">
            </label>
        </div>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
