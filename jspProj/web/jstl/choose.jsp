<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:choose</title>
</head>
<body>
<h3>c:choose 判断成绩等级</h3>

<%--
c:choose 相当于switch判断
--%>

<%
    /*
    成绩等级规则
    优秀：>= 80
    合格：>=60
    不及格: <60
     */
    // request对象中保存一个分数
    request.setAttribute("score", 80);
%>

<div>
    <p>成绩：${requestScope.score}分</p>

    <p>等级：
        <c:choose>
            <c:when test="${requestScope.score >= 80}">
                优秀
            </c:when>
            <c:when test="${requestScope.score >= 60}">
                合格
            </c:when>
            <c:otherwise>
                不及格
            </c:otherwise>
        </c:choose>
    </p>
</div>
</body>
</html>
