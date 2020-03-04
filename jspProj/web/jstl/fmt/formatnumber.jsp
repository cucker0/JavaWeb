<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>fmt:formatNumber</title>
</head>
<body>
<h3>fmt:formatNumber函数</h3>

<div>
    <fmt:setLocale value="fr_fr"/>
    <fmt:formatNumber value="123456789.012"/>
<%--    123 456 789,012--%>
    <br/>
    <fmt:setLocale value="zh_cn"/>
    <fmt:formatNumber value="123456789.012"/>
<%--    123,456,789.012--%>
    <br />
    <fmt:setLocale value="de_de"/>
    <fmt:formatNumber value="123456789.012"/>
<%--    123.456.789,012--%>
    <br />
</div>

<br>
<div>
    <fmt:setLocale value="zh_cn"/>
    数字：<fmt:formatNumber value="0.3" type="number"/><br />
    货币：<fmt:formatNumber value="0.3" type="currency"/><br />
    百分数：<fmt:formatNumber value="0.3" type="percent"/><br />
</div>

<br>
<div>
    <fmt:formatNumber value="12" type="currency" pattern="$.00"/>  <br/>
    <fmt:formatNumber value="12" type="currency" pattern="$.#"/> <br/>
    <fmt:formatNumber value="12" type="currency" pattern="￥.00"/> <br/>
    <fmt:formatNumber value="12" type="currency" pattern="#0.00元"/> <br/>
    <fmt:formatNumber value="12" type="currency"/>
</div>
</body>
</html>
