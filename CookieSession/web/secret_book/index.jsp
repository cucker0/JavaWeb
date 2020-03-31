<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/head.jsp" %>
    <title>武林秘籍</title>
    <style type="text/css">
        h2 {
            text-align: center;
            margin: 60px 0;
        }
        .userinfo {
            margin: 30px 0;
            text-align: right;
            padding: 0 150px 0 0;
            /*color: gray;*/
        }
        .userinfo li {
            display: inline-block;
            padding: 0 0 0 10px;
        }
    </style>
</head>
<body>
<h2>欢迎光临武林秘籍管理系统</h2>

<c:choose>
    <%-- 未登录 --%>
    <c:when test="${empty sessionScope.user}">
        <div>
            <h4>游客你好，如果想查看武林秘籍，请
                <a href="secret_book/login.jsp">登录</a>
            </h4>
        </div>
        <div>
            <h4>普通武功秘籍</h4>
            <ul>
                <li><a href="secret_book/level1/1.jsp">罗汉拳</a></li>
                <li><a href="secret_book/level1/2.jsp">武当长拳</a></li>
                <li><a href="secret_book/level1/3.jsp">全真剑法</a></li>
            </ul>
        </div>
    </c:when>

    <%-- 已登录 --%>
    <c:otherwise>
        <div class="userinfo">
            <li>${sessionScope.user}你好</li>
            <li><a href="userServlet?action=logout">退出</a></li>
        </div>
        <div>
            <h4>普通武功秘籍</h4>
            <ul>
                <li><a href="secret_book/level1/1.jsp">罗汉拳</a></li>
                <li><a href="secret_book/level1/2.jsp">武当长拳</a></li>
                <li><a href="secret_book/level1/3.jsp">全真剑法</a></li>
            </ul>
        </div>

        <div>
            <h4>高级武功秘籍</h4>
            <ul>
                <li><a href="secret_book/level2/1.jsp">太极剑</a></li>
                <li><a href="secret_book/level2/2.jsp">七伤拳</a></li>
                <li><a href="secret_book/level2/3.jsp">梯云纵</a></li>
            </ul>
        </div>

        <div>
            <h4>绝世武功秘籍</h4>
            <ul>
                <li><a href="secret_book/level3/1.jsp">葵花宝典</a></li>
                <li><a href="secret_book/level3/2.jsp">龟派气功</a></li>
                <li><a href="secret_book/level3/3.jsp">独狐九剑</a></li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
