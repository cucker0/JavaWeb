<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 动态的baseUrl --%>
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
<link rel="icon" href="static/img/favicon.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-3.4.1.min.js"></script>