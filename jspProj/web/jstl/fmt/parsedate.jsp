<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>fmt:parseDate标签</title>
</head>
<body>
<h3>fmt:parseDate标签</h3>

<div>
    <fmt:setLocale value="zh_cn" />
    <fmt:parseDate type="date" value="2020-3-5" pattern="yyyy-M-d"/>
<%--    Thu Mar 05 00:00:00 CST 2020--%>

</div>


</body>
</html>
