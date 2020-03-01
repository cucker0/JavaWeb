<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取域属性顺序</title>
</head>
<body>
<h3>EL表达式获取域属性顺序</h3>

<%
    application.setAttribute("city", "浙江");
//    session.setAttribute("city", "湖南");
    request.setAttribute("city", "河南");
//    pageContext.setAttribute("city", "武汉");

    // 获取顺序跟书写顺顺序没有关系，
    // 从域对象中获取优先顺序(从作用范围小的到大的)：pageContext -> request -> session -> application
%>

<div>2020年疫情严重的城市：${city}</div>

<h4>输出不存在的域属性值</h4>
<div>
    JSP表达式脚本输出不存在的属性值：<%= request.getAttribute("age") %>
</div>

<div>
    EL表达式输出不存在的属性值：${age}
</div>
</body>
</html>
