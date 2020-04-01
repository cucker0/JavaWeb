<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<html>
<head>
    <title>用户中心</title>
    <base href="<%= baseUrl %>">
    <style type="text/css">
        .container {
            width: 1024px;
            margin: auto;
        }
        .box {
            margin: 20px 0 0 0;
        }
        .menu div {
            width: 100px;
            height: 60px;
            float: right;
        }
        .clearfix:before, .clearfix:after {
            display: table;
            content: '';
            clear: both;
        }
    </style>
</head>
<body>
<div class="container clearfix">
    <c:choose>
        <%-- 访问指定的cookie, 格式：cookie.cookie名 --%>
        <c:when test="${not empty cookie.user}">
            <div class="menu clearfix">
                <div>
                    <a href="loginServlet?action=logout">退出登录</a>
                </div>
            </div>

            <div class="box">
                <h3>用户中心</h3>
                    ${cookie.user.value} 你好！
            </div>

        </c:when>
        <c:otherwise>
            <div class="box">
                访问用户中心，需要登录
                <a href="manager/login.jsp">[登录]</a>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
