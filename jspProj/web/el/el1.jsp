<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP表达式脚本 与 EL表达式 </title>
</head>
<body>
<h3>初识EL表达式</h3>

<%
    // 在request中设置一个属性
    request.setAttribute("name", "Jarry");
%>

<%-- jsp脚本表达式输出 --%>
<div>
    jsp脚本表达式输出：<%= request.getAttribute("name") %>
</div>

<%-- EL表达式输出 --%>
<div>
    EL表达式输出：${name}
</div>

</body>
</html>
