<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myfmt" uri="http://www.java.com/myformat" %>
<html>
<head>
    <title>自定义格式化标签库(手机号、身份证号、银行卡号)</title>
</head>
<body>
<h3>自定义格式化标签库(手机号、身份证号、银行卡号)</h3>

<div>
    手机号: <myfmt:formatPhone value="15826180208"/> <br>
    身份证: <myfmt:formatIdNumber value="11010119900307539X" /> <br>
    银行卡号：<myfmt:formatBankcardNumber value="6216683269854492886" /> <br>
</div>
</body>
</html>
