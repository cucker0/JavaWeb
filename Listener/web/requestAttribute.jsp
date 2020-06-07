<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request Attribute监听器</title>
</head>
<body>
<%
    // 添加属性
    request.setAttribute("username", "张亢");
    // 修改属性值
    request.setAttribute("username", "张骞");
    // 删除属性
    request.removeAttribute("username");
%>
<h3>request Attribute监听器</h3>
<div>
    请观察tomcat控制台的打印信息... ...
</div>
</body>
</html>
