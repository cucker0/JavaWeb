<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<%-- 设置地区对象 --%>
<fmt:setLocale value="${param.locale}"/>
<%-- 设置bundle对象 --%>
<fmt:setBundle basename="i18n"/>
<head>
    <title>国际化</title>
</head>
<body>
<div class="content">
    <h3>i18n国际化--fmt标签版</h3>
    <div>
        <a href="i18n_fmt.jsp">默认</a> |
        <a href="i18n_fmt.jsp?locale=zh_CN">中文</a> |
        <a href="i18n_fmt.jsp?locale=en_US">english</a> |
        <a href="i18n_fmt.jsp?locale=ko_KR">한국어</a>
    </div>
    <div>
        <h4>
            <fmt:message key="register"/>
        </h4>
        <form>
            <table>
                <tr>
                    <td>
                        <fmt:message key="username"/>：
                    </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>
                        <fmt:message key="password"/>：
                    </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>
                        <fmt:message key="sex"/>：
                    </td>
                    <td>
                        <label>
                            <input type="radio" name="sex" checked="checked"
                                   value="female"><fmt:message key="female"/>
                        </label>
                        <label>
                            <input type="radio" name="sex" value="male"><fmt:message key="male"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <fmt:message key="email"/>：
                    </td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="<fmt:message key="reset" />">
                    </td>
                    <td>
                        <input type="submit" value="<fmt:message key="submit" />">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<br>
<div>
    <%
        session.setAttribute("username", "赵四");
        session.setAttribute("msg", "今天晴转多云");
    %>
    <h4>国际化参数</h4>
    <div>
        <fmt:message key="msg">
            <%-- 参数{0}的值 --%>
            <fmt:param value="${ sessionScope.username }"></fmt:param>
            <%-- 参数{1}的值 --%>
            <fmt:param value="${ sessionScope.msg }"></fmt:param>
        </fmt:message>
    </div>
</div>
</body>
</html>
