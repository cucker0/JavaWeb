<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>fn:length()</title>
</head>
<body>
<h3>fn:length(obj) 返回集合或者字符串的长度</h3>

<div>
    fn:trim("Simple is better than complex.") 结果：
    <%-- 相当于 str.length() --%>
    ${fn:length("Simple is better than complex.")}
</div>

<%
    List<Object> list = new ArrayList<Object>();
    list.add("a");
    list.add("b");
    // list集合
    pageContext.setAttribute("list", list);

    Map<String,Object> map = new HashMap<String,Object>();
    map.put("a", "a");
    map.put("b", "b");
    map.put("c", "c");
    // 添加map集合
    pageContext.setAttribute("map", map);
    // 添加数组
    Object[] arr = new Object[10];
    arr[0] = 12;
    pageContext.setAttribute("arr", arr);
%>
<div>
<%--    相当于array.length --%>
    数组长度：${fn:length(arr)} <br>
<%--    相当于list.size()--%>
    list长度：${fn:length(list)} <br>
<%--    相当于map.size()--%>
    map长度：${fn:length(map)} <br>
</div>
</body>
</html>
