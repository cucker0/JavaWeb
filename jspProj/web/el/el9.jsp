<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>"."点 和 []运算符</title>
</head>
<body>
<h3>"."点 和 []运算符</h3>

<%
    Map map = new HashMap();
    map.put("aaa", "aaa_Value");
    map.put("a-b-c", "a-b-c_Value");
    map.put("a.b.c", "a.b.c.Value");

    request.setAttribute("map", map);
%>

map.aaa: ${map.aaa}
map["a-b-c"]: ${map["a-b-c"]} <br>
map["a.b.c"]: ${map["a.b.c"]} <br>
</body>
</html>
