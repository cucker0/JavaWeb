<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>购物车</title>
    <script>

        /**
         * 解析整数
         *
         * @param numStr  要解析的数字字符串
         * @param defaultVal  默认值
         * @returns {number|*}
         */
        function myParseInt(numStr, defaultVal) {
            if (!isNaN(numStr)) {
                num = parseInt(numStr);
                return num;
            }
            return defaultVal;
        }

        // 数量增\ 减
        function quantity(e, type) {
            var selector = $(e).parent("div").find("input[name=count]");
            var num = myParseInt(selector.val(), 1);
            if (type === "+") { // +1操作
                // selector.val(num + 1);
                selector.val(num + 1);
                if (num === 0) {
                    $(e).parent().find("span.decrement").removeClass("disabled-pointer-events");
                }
            } else { // -1操作
                if (selector.val() < 1) {
                    return false;
                }
                selector.val(num - 1);
                if (myParseInt(selector.val(), 1) === 0) {
                    $(e).addClass("disabled-pointer-events");
                }
            }
            // 给目标标签触发input事件
            selector.trigger("input");
        }

        // 页面就绪后绑定事件
        $(function () {
            // 数值表-1操作
            $(".quantity-form span.decrement").click(function () {
                quantity(this, "-");
            });

            // 数值表+1操作
            $(".quantity-form span.increase").click(function () {
                quantity(this, "+");
            });
            // 商品数量变化时，向服务器发情请求更新购物车商品的数量
            $(".quantity-form input[name=count]").on("input propertychange", function () {
                var _count = $(this).val();
                var _id = $(this).attr("goods-id");
                location.href = "cartServlet?action=updateGoodsCount&id=" + _id + "&count=" + _count;
            });

            // 全选 / 取消 购物车所有商品
            $("input.checkeda-all").click(function () {
                location.href = "cartServlet?action=checkedAllOrNot";
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        <a href="">返回</a>
    </div>
</div>

<div id="main">
    <c:choose>
        <c:when test="${not empty sessionScope.cart.goodsMap}">
            <table>
                <tr>
                    <td class="td-w3">
                        <label>
                            <input type="checkbox" class="checkeda-all y-middle" ${sessionScope.cart.isAllChecked() ? 'checked="checked"' : ""}>全选
                        </label>
                    </td>
                    <td>商品名称</td>
                    <td>数量</td>
                    <td>单价</td>
                    <td>小计</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="item" items="${sessionScope.cart.goodsMap.values()}">
                    <tr>
                        <td class="td-w3">
                            <input goods-id="${item.id}" type="checkbox" class="y-middle" ${item.isChecked() ? 'checked="checked"' : ""}>
                        </td>
                        <td>${item.name}</td>
                        <td>
                            <div class="quantity-form">
                                <span class="decrement">-</span>
                                <input goods-id="${item.id}" type="text" name="count" value="${item.count}">
                                <span class="increase">+</span>
                            </div>
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.price}" type="currency" pattern="￥.00"/>
                        </td>
                        <td>
                            <fmt:formatNumber value="${item.getTotalPrice()}" type="currency" pattern="￥.00"/>
                        </td>
                        <td><a href="cartServlet?action=deleteGoods&id=${item.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>

            <div class="cart_info">
                <span class="cart_span">已选择<span
                        class="b_count">${sessionScope.cart.getTotalCount()}</span>件商品</span>
                <span class="cart_span">
            总金额
            <span class="b_price">
                <fmt:formatNumber value="${sessionScope.cart.getTotalPrice()}" type="currency" pattern="￥0.00"/>
            </span>
        </span>
                <span class="cart_span"><a href="cartServlet?action=clearCart">清空购物车</a></span>
                <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
            </div>
        </c:when>
<%--        购物车还没有添加商品--%>
        <c:otherwise>
            <div style="text-align: center; margin-top: 80px; font-size: 22px">
                <a href="">当前购物车为空！赶紧购物！</a>
            </div>
        </c:otherwise>
    </c:choose>


</div>

<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>