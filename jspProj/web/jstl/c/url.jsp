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
只能有一下两个属性，值都以/开头
    context: 工程path
    value: 要访问的资源path
--%>
<c:url context="/user" value="/login.jsp">
    <c:param name="username" value="xiaoming"></c:param>
    <c:param name="password" value="pw123654"></c:param>
</c:url>
<%--
最后输出结果为：
/user/login.jsp?username=xiaoming&password=pw123654
--%>
</div>


<%--
生成一个URL地址，保存到指定的域对象中，只能在当前工程下
scope="与对象"  指定保存到那个域对象中
var="key"
--%>

<%-- 使用绝对路径生成URL --%>
<c:url var="li" context="/list" value="/list.jsp" scope="request">
    <c:param name="type" value="all"></c:param>
    <c:param name="isCurrent" value="true"></c:param>
</c:url>
<div>
    绝对URL：${requestScope.li}
<%--
结果：
绝对URL：/list/list.jsp?type=all&isCurrent=true
--%>
</div>

<%-- 使用相对路径生成URL，相对于当前工程path --%>
<c:url var="url3" value="/a.jsp" scope="page">
    <c:param name="id" value="10101"></c:param>
    <c:param name="data" value="QQ"></c:param>
</c:url>
<div>
    相对URL：${pageScope.url3}
<%--
结果：
相对URL：/jsp/a.jsp?id=10101&data=QQ
--%>
</div>
</body>
</html>
