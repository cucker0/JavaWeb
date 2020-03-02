<%@ page import="com.java.el.bean.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域对象属性值</title>
</head>
<body>
<h3>EL获取域对象属性值</h3>

<%
    // 创建Person对象
    Person p = new Person();
    p.setId(02);
    p.setArr(new String[]{"A城", "B城", "C城"});
    List<String> list = new ArrayList<>();
    list.add("啊U学科学");
    list.add("小猪佩奇");
    list.add("奇宝萌兵");
    p.setList(list);
    Map<String, String> map = new HashMap<>();
    map.put("dbq", "对不起");
    map.put("xswl", "笑死我了");
    map.put("nbcs", "nobody cares");
    p.setMap(map);

    request.setAttribute("p", p);
%>

<div>
    输出person对象：${p} <br>
    输出person.id属性值：${p.id} <br>
    输出person.arr属性值：${p.arr[0]} <br>
    输出person.list属性值：${p.list} <br>
    输出person.map属性值：${p.map} <br>
</div>

</body>
</html>
