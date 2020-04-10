<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@ include file="/pages/common/head.jsp" %>
    <%@ include file="/pages/common/bootstrap.jsp" %>
    <style type="text/css">
        #main {
            overflow: unset;
        }
    </style>
    <script>
        $(function () {
            // 按价格分页查询
            $(".search-by-price button").click(function () {
                specifyPageQuery(1);
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <div>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="pages/user/login.jsp">登录</a> |
                <a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
            </c:when>
            <c:otherwise>
                <a href="pages/user/login_success.jsp">${sessionScope.user.username}</a> &nbsp;&nbsp;
            </c:otherwise>
        </c:choose>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="search-by-price text-center">
            价格：
            <input size="3" value="${param.get("min_price")}" placeholder="￥" >
            -
            <input size="3" value="${param.get("max_price")}" placeholder="￥" >
            <button>确定</button>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>

        <c:forEach var="book" items="${requestScope.page.items}">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">
<%--                            <fmt:formatNumber value="${book.price}" type="currency" pattern="￥.00"/>--%>
                            ${book.price}
                        </span>

                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">
                            <c:forEach var="author" items="${book.authors}" varStatus="status">
                                <c:choose>
                                    <c:when test="${status.last}">
                                        ${author["name"]}
                                    </c:when>
                                    <c:otherwise>
                                        ${author["name"]} |
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </span>

                    </div>

                    <div class="book_add">
                        <button>加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
<%--        分页导航条--%>
        <%@ include file="/pages/common/page_navigation.jsp" %>
    </div>

</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>