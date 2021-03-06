<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        // URL格式：
        // https://ip:port/工程名/
        String baseUrl = "";
        String host = request.getServerName();
        if (request.getScheme().equalsIgnoreCase("https") && request.getServerPort() == 443) {
            baseUrl = String.format("%s://%s%s/", request.getScheme(), host, request.getContextPath());
        } else if (request.getScheme().equalsIgnoreCase("http") && request.getServerPort() == 80) {
            baseUrl = String.format("%s://%s%s/", request.getScheme(), host, request.getContextPath());
        } else {
            baseUrl = String.format("%s://%s:%s%s/", request.getScheme(), host, request.getServerPort(), request.getContextPath());
        }
    %>
    <meta charset="UTF-8">
    <base href="<%= baseUrl %>">
    <title>JavaScript</title>
</head>
<body>
<div>
    <a href="ajax/ajax_js.html">ajax_js原生请求</a>
</div>
<div>
    <a href="jQuery/ajax_jQeury.html">ajax jQuery</a>
</div>
</body>
</html>
