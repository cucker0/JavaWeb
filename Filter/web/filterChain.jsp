<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FilterChain</title>
</head>
<body>
<h3>FilterChain</h3>
<div>
    FilterChain测试
    <%
        System.out.println("这是请求的资源代码");
    %>
</div>
</body>
</html>

<%--
控制台打印结果：

访问资源前，FilterChain1 doFilter开始执行
访问资源前，FilterChain2 doFilter开始执行
这是请求的资源代码
访问资源后，FilterChain2 doFilter执行结束
访问资源后，FilterChain1 doFilter执行结束
--%>