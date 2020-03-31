<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>禁用浏览器cookie情况下，使用session</title>
    <style type="text/css">
        ul li {
            list-style: none;
        }

        iframe {
            width: 500px;
            height: 500px;
            float: left;
            border: grey 1px solid;
            margin: 0 20px 0 0;
        }

        .option {
            float: left;
        }

        .clearfix:before, .clearfix:after {
            display: table;
            content: "";
            clear: both;
        }
    </style>
</head>
<body>
<h3>禁用浏览器cookie情况下，使用session</h3>


<div class="container clearfix">
    <%--
    思路：
    在URL中添加cookie信息，
    格式 http://ip:port;JSESSIONID=sessionId?参数
    --%>

    <%-- 方法1 --%>
    <%
        String sessionUrl = response.encodeRedirectURL("sessionServlet?action=createOrGetSession");
    %>

    <iframe name="target"></iframe>

    <div class="option">
        <li><a target="target" href="sessionServlet?action=createOrGetSession">session的创建和获取(id,是否为新创建)，默认方法</a></li>
        <li><a target="target" href="<%= sessionUrl%>">session的创建和获取(id,是否为新创建)，通过URL传cookie，生成URL方式1</a></li>
        <li><a target="target" href="<c:url value="sessionServlet?action=createOrGetSession" />">session的创建和获取(id,是否为新创建)，通过URL传cookie，生产URL方式2</a></li>
    </div>
</div>

</body>
</html>
