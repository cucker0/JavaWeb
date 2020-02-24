<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp表达式脚本语法</title>
</head>
<body>
<h3>jsp表达式脚本语法</h3>

<%!
    private static Map<String, String> map;

    static {
        System.out.println("静态代码块");
        map = new HashMap<>();
        map.put("sn11", "小波");
        map.put("sn12", "吴曦");
    }
%>


<pre>
<!-- 输出整型 -->
<%= 1 %>

    <!-- 输出浮点型 -->
<%= 3.1 %>

    <!-- 输出字符串 -->
<%= "Center of city" %>

    <!-- 输出对象 -->
<%= map %>
</body>
</html>
