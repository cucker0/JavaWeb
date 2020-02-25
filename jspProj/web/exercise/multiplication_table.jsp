<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>乘法表</title>
    <style type="text/css">
        .multiplication-table li {
            display: inline-block;
            width: 90px;
            list-style: none;
        }
    </style>
</head>
<body>
<h3>在jsp中输出九九乘法口诀表（输出在页面）</h3>

<div class="multiplication-table">
    <%
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= i; ++j) { %>
    <li>
        <%= j %> * <%= i %> = <%= j * i %>
    </li>
    <% } %>
    <br>
    <% } %>
</div>

</body>
</html>
