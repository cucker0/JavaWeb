<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:substring()</title>
</head>
<body>
<h3>fn:substring(str, beginIndex, endIndex) 截取字符串</h3>
<div>
    fn:substring("abcdefg", 0, 3) 结果：
    ${fn:substring("abcdefg", 0, 3)} <br>
</div>
</body>
</html>
