<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式其他隐含对象</title>
</head>
<body>
<h3>EL表达式其他隐含对象</h3>

<div>
<%--
// 客户端的request headers

GET /jsp/el/el12.jsp HTTP/1.1
Host: 127.0.0.1:8080
Connection: keep-alive
Cache-Control: max-age=0
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36
Sec-Fetch-Dest: document
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Referer: http://localhost:8080/jsp/
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9
Cookie: JSESSIONID=2E7D6788706E3BF0DE91540D4DE16340
--%>

    request参数username的值：${param.username}<br>
    参数hobby的数组值：${paramValues.hobby}<br>
    参数hobby的数组中第一个值：${paramValues.hobby[0]}<br>
    请求头Accept-Language值：${header["Accept-Language"]}<br>
    请求头Accept值：${headerValues["Accept"][0]}<br>
    cookie：key = ${cookie.JSESSIONID.name}, value = ${cookie.JSESSIONID.value}<br>
<%-- 上下文参数，从web.xml中获取，修改web.xml需要重启tomcat才能生效 --%>
    上下文参数(username)：${initParam.username} <br>
    上下文参数(password)：${initParam.password}

</div>
</body>
</html>
