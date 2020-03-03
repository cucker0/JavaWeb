<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:join()</title>
</head>
<body>
<h3>fn:join(array, sparator) 用指字符串将数据中的元素连接起来</h3>

<%
    pageContext.setAttribute("arr", new String[]{"top", "bottom", "left", "right"});
%>
<div>
    fn:join(pageScope.arr, "==>")结果：

    ${fn:join(pageScope.arr, " ==> ")}
</div>
</body>
</html>
