<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:indexOf()</title>
</head>
<body>
<h3>fn:indexOf("string", "subString") 查找子字符串的索引位置，没有则返回-1</h3>
<div>
    fn:indexOf("abcdefg", "cd") 结果：
    ${fn:indexOf("abcdefg", "cd")} <br>
    fn:indexOf("abcdefg", "id") 结果：
    ${fn:indexOf("abcdefg", "id")} <br>
</div>
</body>
</html>
