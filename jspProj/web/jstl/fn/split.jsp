<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>fn:split()</title>
</head>
<body>
<h3>fn:split(string, delimiters) 分割字符串，并返回分割后的str[]数组</h3>

<div>
    fn:split("fe80::b81b:2702:a205:92da%", ":")[0] 结果：
    ${fn:split("fe80::b81b:2702:a205:92da%", ":")[0]} <br>

    遍历fn:split("fe80::b81b:2702:a205:92da%", ":") ：
    <c:forEach var="v" items='${fn:split("fe80::b81b:2702:a205:92da", ":")}'>
        <p>${v}</p>
    </c:forEach>
</div>
</body>
</html>
