<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>out vs getWriter()</title>
</head>
<body>
<%
    out.write("out输出1 <br>");
    out.flush(); // 把当前out缓冲区的内容追加到response缓冲区中，并清空out缓冲区中所有的内容
    out.write("out输出2 <br>");

    response.getWriter().write("response.getWriter()输出1 <br>");
    response.getWriter().write("response.getWriter()输出2 <br>");
%>
</body>
</html>
