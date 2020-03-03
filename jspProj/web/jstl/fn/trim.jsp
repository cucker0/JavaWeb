<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:trim()</title>
</head>
<body>
<h3>fn:trim(str) 去掉字符串前后的空格</h3>

<div>
    fn:trim("  Now is better than never.   ") 结果：
    ${fn:trim("  Now is better than never.   ")}
</div>
</body>
</html>
