<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:replace()</title>
</head>
<body>
<h3>fn:replace(str, beforeSubString, afterSubString) 返回替换后的字符串</h3>
<div>
    fn:replace("abcdefg", "de", "[xxx]") 结果：
    ${fn:replace("abcdefg", "de", "[xxx]")} <br>
</div>
</body>
</html>
