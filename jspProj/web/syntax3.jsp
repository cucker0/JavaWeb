<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp代码脚本语法</title>
</head>
<body>
<h3>jsp代码脚本语法</h3>

<%
    // 定义变量
    int i = 0;
    if (i == 0) {
        System.out.println("i等于0");
    } else {
        System.out.println("i不等于0");
    }
%>

<% for (int j = 0; j < 5; ++j) { %>
    <h4>标题<%= j %></h4>
<% } %>

<%-- jsp源文件翻译后的文件中的 _jspService 方法里的代码，也可以写 --%>
<%
    System.out.println(request.getParameter("id"));
    out.print("jsp语法测试");
%>
</body>
</html>
