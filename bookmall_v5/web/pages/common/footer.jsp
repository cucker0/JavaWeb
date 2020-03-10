<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    LocalDate now = LocalDate.now();
    int yearStr = now.getYear();
%>
<div id="bottom">
    <span>
        尚硅谷书城.Copyright &copy; <%= yearStr %>
    </span>
</div>
