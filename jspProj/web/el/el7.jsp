<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>empty运算符</title>
</head>
<body>
<h3>empty运算符</h3>

<%
    // 空对象
    request.setAttribute("nullObj", null);
    // 空字符串
    request.setAttribute("emptyStr", "");
    // 空数组
    request.setAttribute("emptyArr", new Object[]{});
    // 空list
    request.setAttribute("emptyList", new ArrayList());
    // 空map
    request.setAttribute("emptyMap", new HashMap());
%>

<div>
    对象是否为null: ${empty nullObj} <br>
    字符串是否为空: ${empty emptyStr} <br>
    数组是否为空: ${empty emptyArr} <br>
    list是否为空: ${empty emptyList} <br>
    map是否为空: ${empty emptyMap} <br>
</div>
</body>
</html>
