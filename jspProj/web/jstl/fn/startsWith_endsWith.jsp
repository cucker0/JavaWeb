<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:startsWith() \ fn:endsWith()</title>
</head>
<body>
<h3>fn:startsWith("string", "prefix") \ fn:endsWith("string", "suffix")</h3>

<div>
    fn:startsWith("abcde", "abc") 结果：
    ${fn:startsWith("abcde", "abc")} <br>
    fn:startsWith("abcde", "ddd") 结果：
    ${fn:startsWith("abcde", "ddd")} <br>
    fn:endsWith("abcde", "abc") 结果：
    ${fn:endsWith("abcde", "abc")} <br>
    fn:endsWith("abcde", "de") 结果
    ${fn:endsWith("abcde", "de")} <br>
</div>
</body>
</html>
