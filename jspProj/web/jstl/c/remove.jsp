<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>c:remove</title>
</head>
<body>
<h3>c:remove</h3>

<%-- 添加一个属性值 --%>
<c:set scope="page" var="k1" value="k1_value"></c:set>

k1值：${pageScope.k1} <br>

<%-- 删除属性k1 --%>
<c:remove scope="page" var="k1"></c:remove>
k1属性remove后：${pageScope.k1} <br>

</body>
</html>
