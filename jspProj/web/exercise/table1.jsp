<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>练习1</title>
    <style type="text/css">
        table {
            width: 300px;
            margin: 0 auto;
            border-collapse: collapse; /* 合并表格边距 */
        }
        td, th {
            border: 1px solid black;
        }

        .even {
            background: skyblue;
        }
    </style>
</head>
<body>
<h3>使用代码脚本和表达式脚本输出一个5*5的表格，而且要隔行变色</h3>

<div>
    <table>
        <tr>
            <th>#</th>
            <th>动作</th>
        </tr>
        <% for (int i = 1; i <= 5; ++i) { %>
        <% if (i % 2 == 0) { %>
        <tr class="even">
                <% } else { %>
        <tr>
            <% } %>

            <td><%= i %>
            </td>
            <td><a href="#">删除</a></td>
        </tr>
        <% } %>

    </table>
</div>
</body>
</html>
