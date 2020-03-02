<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:if</title>
</head>
<body>
<h3>c:if</h3>

<%--
判断逻辑值，
如果为真，输出c:if标签中间的内容，反之则不输出
--%>
<div>
    <c:if test="${1 < 3}">
        1 < 3 成立就输出
    </c:if>
</div>

<%-- 把判断结果保存到域对象中 --%>
<div>
    <c:if scope="request" var="ret" test="${1 == 1}"></c:if>
    1 == 1 结果：
    ${requestScope.ret}
</div>

</body>
</html>
