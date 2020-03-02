<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl c:url</title>
</head>
<body>
<h3>jstl c:url</h3>

<div>
<%--
生成一个可访问的URL地址，直接输出到html页面
context: 工程path
value: 要反问的资源path
--%>

<c:url context="/user" value="/login.jsp">
    <c:param name="username" value="xiaoming"></c:param>
    <c:param name="password" value="pw123654"></c:param>
</c:url>
</div>


<%--
生成一个URL地址，保存到指定的域对象中
scope="与对象"  指定保存到那个域对象中
var="key"
--%>
<c:url context="/list" value="/list.jsp" scope="request" var="li">
    <c:param name="type" value="all"></c:param>
    <c:param name="isCurrent" value="true"></c:param>
</c:url>
<div>
${requestScope.li}
</div>
</body>
</html>
