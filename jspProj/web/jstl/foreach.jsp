<%@ page import="com.java.jsp.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:forEach</title>
    <style type="text/css">
        table {
            width: 800px;
            border: 1px solid skyblue;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid skyblue;
        }
    </style>
</head>
<body>
<h3>c:forEach</h3>

<%--
遍历 1 - 10的整数


c:forEach
items 你需要遍历的数据源
    begin表示从索引0开始，
    end表示到索引10结束，
    step表示迭代的步长
    items是遍历的集合
    var是当前遍历到的对象名
    varStatus是当前遍历的状态对象，是LoopTagStatus对象实例
--%>
<h4>1-10的整数</h4>
<c:forEach var="i" begin="1" end="10">
    ${i}
</c:forEach>


<%--
遍历数组
--%>
<h4>遍历数组</h4>
<div>
    <%
        request.setAttribute("arr", new Object[]{"sox", 23, 3.14, true});
    %>

    <c:forEach var="obj" items="${arr}">
        <span style="margin: 0 0 0 20px">${obj}</span>
    </c:forEach>
</div>

<%--
遍历List
--%>
<h4>遍历List</h4>
<div>
    <%
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 6; ++i) {
            students.add(new Student(i, "name_" + i, "158 0001 123" + i));
        }
        request.setAttribute("stus", students);
    %>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>电话</th>
            <th>操作</th>
            <th>遍历的个数</th>
            <th>当前索引</th>
            <th>是否为第一个</th>
            <th>是否为最后一个</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${requestScope.stus}" varStatus="status">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.phone}</td>
                <td>
                    <a href="javascript:void 0;">修改</a>
                    <a href="javascript:void 0;">删除</a>
                </td>
                <td>${status.count}</td>
                <td>${status.index}</td>
                <td>${status.first}</td>
                <td>${status.last}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
