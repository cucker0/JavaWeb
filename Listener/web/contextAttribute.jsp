<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>servletContextAttribute</title>
</head>
<body>
<%
    // 添加属性
    application.setAttribute("count", 0);
    // 修改属性值
    application.setAttribute("count", 10);
    // 删除属性
    application.removeAttribute("count");
%>
<h3>servletContextAttribute监听器</h3>
<div>
    请观察tomcat控制台的打印信息... ...
</div>
</body>
</html>
