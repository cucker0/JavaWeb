<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/head.jsp" %>
    <title>武林秘籍管理系统</title>
    <style type="text/css">
        label {
            display: block;
        }
        label i {
            font-style: normal;
            display: inline-block;
            width: 80px;
        }
        form .submit {
            margin: 20px 0 0 210px;
        }
    </style>
</head>
<body>
<div>
    <h4>登录武林秘籍管理系统</h4>
    <form action="userServlet?action=login" method="post">
        <input type="hidden" name="action" value="login">
        <label>
            <i>用户名：</i><input type="text" name="username" value="${param.username}" placeholder="admin">
        </label>
        <label>
            <i>密码：</i><input type="password" name="password" placeholder="ad123456">
        </label>
        <div class="submit">
            <input type="submit">
        </div>
    </form>
</div>
</body>
</html>
