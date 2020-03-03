<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>contains_containsIgnoreCase</title>
</head>
<body>
<h3>fn:contains()、fn:containsIgnoreCase() 查找子字符串</h3>

<div>
    fn:contains("abcde", "ii") 结果：
    ${fn:contains("abcde", "ii")} <br>

    fn:contains("abcde", "AB") 结果：
    ${fn:contains("abcde", "AB")} <br>

    fn:containsIgnoreCase("abcde", "AB") 结果：
    ${fn:containsIgnoreCase("abcde", "AB")} <br>
</div>
</body>
</html>
