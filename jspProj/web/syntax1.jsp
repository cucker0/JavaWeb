<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明式脚本</title>
</head>
<body>
<h3>jsp声明式脚本语法</h3>
<%!
    // 定义全局变量
    private int age;
    private static Map<String, String> map;

    // 定义static静态代码块
    static {
        System.out.println("静态代码块");
        map = new HashMap<>();
        map.put("sn11", "小波");
        map.put("sn12", "吴曦");
    }

    // 定义方法
    public void check() {
        System.out.println("check method");
    }

    // 定义内部类
    public static class Walk {
        private String name;
    }

%>

</body>
</html>
