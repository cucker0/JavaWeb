<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>fmt:formatDate标签</title>
</head>
<body>
<h3>fmt:formatDate标签</h3>

<div>
    <fmt:setLocale value="zh_cn" />
    <fmt:formatDate value="<%=new Date()%>" /> <br>
<%--    2020年3月5日--%>

    <fmt:setLocale value="en_US" />
    <fmt:formatDate value="<%=new Date()%>" /> <br>
<%--    Mar 5, 2020--%>
</div>

<br>
type="time"
<div>
    <fmt:setLocale value="zh_cn" />
    <fmt:formatDate value="<%=new Date()%>" type="time"/> <br>
<%--    上午10:41:59--%>

    <fmt:formatDate value="<%=new Date()%>" type="time" timeStyle="full" /> <br>
<%--    中国标准时间 上午10:41:59--%>

    <fmt:formatDate value="<%=new Date()%>" type="time" timeStyle="full" timeZone="EST" /> <br>
<%--    东部标准时间 下午9:41:59--%>


    <div>-----------------</div>
    <fmt:setLocale value="en_US" />
    <fmt:formatDate value="<%=new Date()%>" type="time"/> <br>
<%--    10:41:59 AM--%>

    <fmt:formatDate value="<%=new Date()%>" type="time" timeStyle="full" /> <br>
<%--    10:41:59 AM China Standard Time--%>

    <fmt:formatDate value="<%=new Date()%>" type="time" timeStyle="full" timeZone="MST" /> <br>
<%--    7:41:59 PM Mountain Standard Time--%>

</div>

<br>
type="both"
<div>
    <fmt:setLocale value="zh_cn" />
    <fmt:formatDate value="<%=new Date()%>" type="both"/> <br>
<%--    2020年3月5日 上午10:41:59--%>

    <fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="short" /> <br>
<%--    2020/3/5 上午10:41:59--%>

    <fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" /> <br>
<%--    2020年3月5日星期四 上午10:41:59--%>

    <div>-----------------</div>
    <fmt:setLocale value="en_US" />
    <fmt:formatDate value="<%=new Date()%>" type="both"/> <br>
<%--    Mar 5, 2020, 10:41:59 AM--%>

    <fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="short" /> <br>
<%--    3/5/20, 10:41:59 AM--%>

    <fmt:formatDate value="<%=new Date()%>" type="both" dateStyle="full" /> <br>
<%--    Thursday, March 5, 2020, 10:41:59 AM--%>
</div>


<h4>自定义日期格式</h4>
<div>
<%--    <fmt:setLocale value="zh_cn" />--%>
    <fmt:setLocale value="en_US" />
    <fmt:formatDate value="<%=new Date()%>" type="both" pattern="yyyy-MM-dd HH:mm:ss.SSS" /> <br>
<%--    2020-03-05 15:53:04.756--%>

    <fmt:formatDate value="<%=new Date()%>" type="both" pattern="yyyy-M-d aa hh:mm:ss" />
<%--    2020-3-5 PM 03:53:04--%>
</div>

</body>
</html>
