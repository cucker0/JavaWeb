<%@ page import="com.java.bean.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sessionActivationListener监听器</title>
</head>
<body>
<%
    Person p = new Person(100L, "王图");
    System.out.println("创建了Person对象：" + p.toString());
    // 只有该类的对象一属性添加到了session对象中，才能随session的钝化、活化时被监听并执行相应的函数
    session.setAttribute("person", p);

/*
// 访问此页面时
创建了Person对象：Person{id=100, name='王图'}

// tomcat正常关闭时
2020-06-08T14:23:28.704898100, Person{id=100, name='王图'}对象被钝化了

// tomcat开启时
2020-06-08T14:24:48.665295700, Person{id=100, name='王图'}对象被活化了
*/
%>
<h3>sessionActivationListener监听器</h3>
<div>
    请观察tomcat控制台的打印信息... ...
</div>
</body>
</html>
