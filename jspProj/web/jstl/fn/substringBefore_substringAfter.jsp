<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:substringBefore() \ fn:substringAfter()</title>
</head>
<body>
<h3>fn:substringBefore(str, subStr) 返回指定字符串之前的子字符串 \ fn:substringAfter(str, subStr) 返回指定字符串之后的子字符串</h3>
<div>
    fn:substringBefore("机器人有很高的工作效率", "有很高") 结果：
    ${fn:substringBefore("机器人有很高的工作效率", "有很高")} <br>
    fn:substringAfter("tom and lilly", "and") 结果：
    ${fn:substringAfter("tom and lilly", "and")} <br>
</div>
</body>
</html>
