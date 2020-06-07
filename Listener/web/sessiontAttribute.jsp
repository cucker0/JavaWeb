<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session Attribute监听器</title>
</head>
<body>
<%
    // 添加属性
    session.setAttribute("city", "深圳");
    // 修改属性值
    session.setAttribute("city", "上海");
    // 删除属性
    session.removeAttribute("city");
%>
<h3>session Attribute监听器</h3>
<div>
    请观察tomcat控制台的打印信息... ...
</div>
</body>
</html>
