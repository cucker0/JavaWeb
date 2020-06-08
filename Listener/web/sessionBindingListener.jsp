<%@ page import="com.java.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session对象绑定监听器测试</title>
</head>
<body>
<%
    User user = new User(11L, "苏谭谭", "ppww123");
    User user2 = new User(12L, "欧丽雯", "olw123");
    session.setAttribute("user", user);
    // 修改属性值，同时是 user 对象的解绑
    session.setAttribute("user", user2);

    session.setAttribute("user3", "Lucy");
    session.setAttribute("user3", user2);
    Thread.sleep(500);
    session.removeAttribute("user");
/*
// 访问此页面，tomcat控制台打印信息
2020-06-08T14:17:38.272197600, User{id=11, name='苏谭谭', password='ppww123'}对象作为属性值被添加到session对象中，key为： user
   session id: 298C1AB62B9FB9FB6EBF1A0EB9A2DB4D
2020-06-08T14:17:38.282170800, User{id=12, name='欧丽雯', password='olw123'}对象作为属性值被添加到session对象中，key为： user
   session id: 298C1AB62B9FB9FB6EBF1A0EB9A2DB4D
2020-06-08T14:17:38.282170800, session对象中的属性值为: User{id=11, name='苏谭谭', password='ppww123'}的key被删除了，key：user
   session id: 298C1AB62B9FB9FB6EBF1A0EB9A2DB4D
2020-06-08T14:17:38.282170800, User{id=12, name='欧丽雯', password='olw123'}对象作为属性值被添加到session对象中，key为： user3
   session id: 298C1AB62B9FB9FB6EBF1A0EB9A2DB4D
2020-06-08T14:17:38.782859400, session对象中的属性值为: User{id=12, name='欧丽雯', password='olw123'}的key被删除了，key：user
   session id: 298C1AB62B9FB9FB6EBF1A0EB9A2DB4D

*/
%>
<h3>session对象绑定监听器测试</h3>
<div>
    请观察tomcat控制台的打印信息... ...
</div>
</body>
</html>
