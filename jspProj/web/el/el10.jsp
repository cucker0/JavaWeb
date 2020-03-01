<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取域对象中的数据</title>
</head>
<body>
<h3>EL表达式获取域对象中的数据</h3>

<%
    application.setAttribute("key", "application value");
    session.setAttribute("key", "session value");
    request.setAttribute("key", "request value");
    pageContext.setAttribute("key", "pageContext value");
%>

<div>
    pageContext的key属性值：${pageScope.key} <br>
    request的key属性值：${requestScope.key} <br>
    session的key属性值：${sessionScope.key} <br>
    application的key属性值：${applicationScope.key} <br>
</div>
</body>
</html>
