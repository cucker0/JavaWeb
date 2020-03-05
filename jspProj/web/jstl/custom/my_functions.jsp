<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myfn" uri="http://www.java.com.functions" %>
<html>
<head>
    <title>自定义jstl函数库</title>
</head>
<body>
<h3>自定义jstl函数库</h3>

<div>
    20岁是否成年：${myfn:isAdult(20)}
</div>
<div class="footer">
    &copy; ${myfn:getYear()} 京ICP备xxxx0661号-1
</div>
</body>
</html>
