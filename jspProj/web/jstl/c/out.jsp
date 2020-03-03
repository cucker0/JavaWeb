<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:out</title>
</head>
<body>
<h3>c:out</h3>

<%--
<c:out value="￥{变量}"></c:out>
效果同 <%= 变量 %>
--%>

<%
    Map<String, String> map = new HashMap<>();
    map.put("username", "chengjiesihan");
    map.put("data", "<b>我是b标签</b>");
    pageContext.setAttribute("map", map);
%>
<div>
    username: <c:out value="${map.username}" default="coco(默认的用户名)"></c:out>
    <br>
    escapeXml="true"时   data: <c:out value="${map.data}" default="默认值" escapeXml="true"></c:out> <br>
    escapeXml="false时   data": <c:out value="${map.data}" default="默认值" escapeXml="false"></c:out> <br>
    变量值为null时显示默认值：<c:out value="${map.op}" default="默认值"></c:out>

</div>

</body>
</html>
