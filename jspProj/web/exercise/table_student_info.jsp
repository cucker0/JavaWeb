<%@ page import="java.util.List" %>
<%@ page import="com.java.jsp.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息表</title>
    <style type="text/css">
        table {
            width: 600px;
            margin: 0 auto;
            border-collapse: collapse; /* 合并表格边距 */
        }

        td, th {
            border: 1px solid black;
        }

        a, a:link, a:visited, a:hover, a:active{
            text-decoration: none;
            color:inherit;
        }
    </style>
</head>
<body>
<%
    // 从request域对象中获取学生信息
    List<Student> stus = (List<Student>) request.getAttribute("stus");
%>
<h3>学生信息表</h3>

<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>电话</th>
            <th>操作</th>
        </tr>

        </thead>
        <%
            for (int i = 0; i < stus.size(); ++i) {
                Student stu = stus.get(i); %>
        <tr>
            <td><%= stu.getId() %>
            </td>
            <td><%= stu.getName() %>
            </td>
            <td><%= stu.getPhone() %>
            </td>
            <td><a href="javascript:void(0);">修改</a> <a href="javascript:void(0);">删除</a></td>
        </tr>
        <% } %>

    </table>
</div>
</body>
</html>
