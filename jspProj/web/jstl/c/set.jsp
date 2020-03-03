<%@ page import="com.java.el.bean.Person" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:set</title>
    <style type="text/css">
        div {
            margin: 20px 0 0 0;
        }
    </style>
</head>
<body>
<h3>c:set</h3>
<%--
<c:set></c:set> 向4个与对象中保存数据

scope="" 可选值：
    page
    request
    session
    application
--%>
<c:set scope="request" var="height" value="180cm"></c:set>
<c:set scope="request" var="sex" value="female"></c:set>


<%--
<c:set></c:set> 修改域对象中的属性值数据(可以是属性值里的一个属性值)


--%>

<div>
    <%
        request.setAttribute("person", new Person(100, null, null, null));
        Map<String, String> map = new HashMap<>();
        map.put("k1", "k1_value");
        map.put("k2", "k3_value");
        map.put("k3", "k3_value");
        request.setAttribute("m", map);
    %>
    person对象修改前：${requestScope.person} <br>
    map对象修改前：${requestScope.m}
</div>
<div>
    <c:set target="${requestScope.person}" property="id" value="101"></c:set>
    <c:set target="${requestScope.m}" property="k1" value="k1新值"></c:set>
    person对象修改后：${requestScope.person} <br>
    map对象修改后：${requestScope.m}
</div>


</body>
</html>
