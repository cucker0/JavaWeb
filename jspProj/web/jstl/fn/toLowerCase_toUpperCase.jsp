<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:toLowerCase() \ fn:toUpperCase()</title>
</head>
<body>
<h3>fn:toLowerCase(str)字母转小写并返回 \ fn:toUpperCase(str)字母转大写并返回</h3>

<div>
    fn:toLowerCase("DAO tool") 结果：
    ${fn:toLowerCase("DAO tool")} <br>
    fn:toUpperCase("nobody cares") 结果：
    ${fn:toUpperCase("nobody cares")} <br>
</div>
</body>
</html>
