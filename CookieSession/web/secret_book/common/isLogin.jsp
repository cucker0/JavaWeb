<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<c:if test="${empty sessionScope.user}">
    <%-- 未登录则跳转到登录页面 --%>
    <c:redirect url="/secret_book/index.jsp"></c:redirect>
</c:if>