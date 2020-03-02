<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过pageContext访问Jsp中内置对象</title>
</head>
<body>
<h3>通过pageContext访问Jsp中内置对象</h3>

<div>
    协议：${pageContext.request.scheme}<br>
    服务器IP：${pageContext.request.serverName}<br>
    服务器port：${pageContext.request.serverPort}<br>
<%-- 工程path是以 /开头--%>
    工程path：${pageContext.request.contextPath}<br>
    客户请求的方法：${pageContext.request.method}<br>
    客户端ip address：${pageContext.request.remoteHost}<br>
    session id：${pageContext.session.id}<br>

    <br>
</div>

<div>
    协议://服务器IP:端口 + 工程路径/ <br>
    ${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/
</div>

</body>
</html>
