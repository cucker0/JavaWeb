<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">
        label {
            display: block;
        }
        b {
            display: inline-block;
            width: 75px;
        }
        .submit {
            margin: 15px 0 0 205px;
        }
        .tips {
            height: 30px;
            color: darkorange;
            padding: 0 0 0 75px;
        }
    </style>
</head>
<body>
<h3>一段时间内免登录</h3>


<div>
    <div class="tips">
        <c:if test="${not empty requestScope.tips}">
            <p>${requestScope.tips}</p>
        </c:if>
    </div>
    <form action="loginServlet?action=login" method="post">
        <label>
            <b>用户名：</b><input type="text" name="username" placeholder="admin">
        </label>
        <label>
            <b>密码：</b><input type="password" name="pwd" placeholder="ad123456">
        </label>
        <div class="submit"><input type="submit" value="提交"></div>
    </form>
</div>
</body>
</html>
