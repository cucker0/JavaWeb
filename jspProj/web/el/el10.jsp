<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<<<<<<< HEAD
    <title>EL表达式获取指定域对象中的数据</title>
</head>
<body>
<h3>EL表达式获取指定域对象中的数据</h3>
=======
    <title>EL表达式获取域对象中的数据</title>
</head>
<body>
<h3>EL表达式获取域对象中的数据</h3>
>>>>>>> 7c16f4079d881ca999e5e7add75186cd2c50e4c1

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
