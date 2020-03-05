<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>fmt:parseNumber标签</title>
</head>
<body>
<h3>fmt:parseNumber标签</h3>

<div>
    <fmt:parseNumber value="500,800,200"/> <br/>
<%--    500800200--%>

    <fmt:parseNumber value="52%" type="percent"/> <br/>
<%--    0.52--%>

    <fmt:parseNumber value="￥123" type="currency"/> <br/>
<%--    123--%>

    <fmt:parseNumber value="$100.333" type="currency" parseLocale="en_US"/><br/>
<%--    100.333
    parseLocale：设置语言环境，不设置时，取当前浏览器的默认值
--%>

    <fmt:parseNumber value="123.333" type="number"/> <br/>
<%--    123.333--%>

    <fmt:parseNumber value="123.333" type="number" integerOnly="true"/> <br/>
<%--    123
integerOnly：只取整数部分
--%>





</div>

</body>
</html>
