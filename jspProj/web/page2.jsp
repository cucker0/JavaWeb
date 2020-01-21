<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/pages/error.html" %>
<html>
<head>
    <title>出错自动显示出错页面的信息</title>
</head>
<body>
    <% int ret = 12 / 0; %>
    <div>
        12 / 0 行不行哦???
    </div>
</body>
</html>
