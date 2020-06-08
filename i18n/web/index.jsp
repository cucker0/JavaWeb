<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<html>
<%
    String lan = request.getParameter("lan");
    String country = request.getParameter("country");
    Locale locale = null;
    if (lan != null && country != null) { // 从request拖头中获取 浏览器希望现实的时区信息
        locale = new Locale(lan, country);
    } else {
        // 获取浏览器接受的语言信息
        /*
        // request headers包含信息：
        Accept-Language: en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7
         */
        String localeStr = request.getHeader("Accept-Language").split(",")[0];
        String[] loc = localeStr.split("-");
        locale = new Locale(loc[0], loc[1]);

        if () {}
        // 获取服务器端的locale信息
        locale = request.getLocale();
    }
    ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n", locale);
%>

<head>
    <title>国际化</title>
</head>
<body>
<div class="content">
    <h3>i18n国际化测试</h3>
    <div>
        <a href="index.jsp?lan=zh&country=CN">中文</a> |
        <a href="index.jsp?lan=en&country=US">english</a>
    </div>
    <div>
        <h4>
            <%= resourceBundle.getString("register") %>
        </h4>
        <form>
            <table>
                <tr>
                    <td>
                        <%= resourceBundle.getString("username") %>：
                    </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>
                        <%= resourceBundle.getString("password") %>：
                    </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>
                        <%= resourceBundle.getString("sex") %>：
                    </td>
                    <td>
                        <label>
                            <input type="radio" name="sex" checked="checked" value="female"><%= resourceBundle.getString("female") %>
                        </label>
                        <label>
                            <input type="radio" name="sex" value="male"><%= resourceBundle.getString("male") %>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <%= resourceBundle.getString("email") %>：
                    </td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="<%= resourceBundle.getString("reset") %>">
                    </td>
                    <td>
                        <input type="submit" value="<%= resourceBundle.getString("submit") %>">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
