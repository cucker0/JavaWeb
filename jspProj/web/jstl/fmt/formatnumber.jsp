<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>formatNumber标签</title>
</head>
<body>
<h3>fmt:formatNumber标签</h3>

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
<%--    数字：0.3--%>

    货币：<fmt:formatNumber value="0.3" type="currency"/><br />
<%--    货币：￥0.30--%>

    百分数：<fmt:formatNumber value="0.3" type="percent"/><br />
<%--  百分数：30%--%>
</div>

<br>
<div>
    <fmt:formatNumber value="12" type="currency" pattern="$.00"/>  <br/>
<%--    $12.00--%>

    <fmt:formatNumber value="12" type="currency" pattern="$.#"/> <br/>
<%--    $12.0--%>

    <fmt:formatNumber value="12" type="currency" pattern="￥0.00"/> <br/>
<%--    ￥12.00
    pattern="￥0.00"  // 当value="0"时显示为 ￥0.00
    pattern="￥.00"  // 当value="0"时显示为 ￥.00
--%>

    <fmt:formatNumber value="12" type="currency" pattern="#0.00元"/> <br/>
<%--    12.00元--%>

    <fmt:formatNumber value="12" type="currency"/> <br>
<%--    ￥12.00--%>

    <fmt:formatNumber value="12.31" pattern=".0000"></fmt:formatNumber> <br>
<%--  12.3100--%>

    <fmt:formatNumber value="1234567" pattern="###.##E0"/>
<%--    1.2346E6--%>
</div>
</body>
</html>
