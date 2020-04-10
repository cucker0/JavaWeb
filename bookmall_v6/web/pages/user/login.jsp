<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 若已经登录，直接跳转到首页 --%>
<c:if test="${not empty sessionScope.user}">
    <c:redirect url="/"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>尚硅谷会员登录页面</title>
    <style type="text/css">
        .imgcode {
            width: 100px;
            height: 38px;
            margin: 0 0 0 15px;
            border: 1px #e3e3e3 solid;
        }
    </style>
    <script type="text/javascript">
        /**
         * 阻止浏览器回退历史页面
         */
        function prevent_return2history() {
            history.go(1);
        }

        // 检查输入用于名、密码的合法性
        function checkUser() {
            // 获取用户名
            var usernameValue = $("#username").val();
            // 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
            var usernameReg = /^\w{5,15}$/;
            // 验证用户信息
            if (!usernameReg.test(usernameValue)) {
                // 提示用户
                alert("用户名不合法！");
                return false;
            }

            // 获取密码
            var passwordValue = $("#password").val();
            // 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
            var passwordReg = /^\w{5,15}$/;
            // 验证用户信息
            if (!passwordReg.test(passwordValue)) {
                // 提示用户
                alert("密码不合法！");
                return false;
            }

            // 阻止表单提交
            return true;
        }

        // 刷新验证码
        function flushImgCode() {
            var time = (new Date()).getTime();
            $(".imgcode")[0].src = "kaptcha.jpg?v=" + time ;
        }

        // 页面加载完成之后
        $(function () {
            // prevent_return2history();

            // 给注册按钮添加事件
            $("#sub_btn").click(checkUser);

            // 刷新验证码
            $(".imgcode").click(flushImgCode);
        });

    </script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <%-- jsp代码脚本处理回显信息 --%>
<%--                        <%= request.getAttribute("tips") == null ? "请输入用户名和密码" : request.getAttribute("tips") %>--%>
                        <%-- EL表达式语言方式，处理回显信息 --%>
                        ${requestScope.tips == null ? "请输入用户名和密码" : requestScope.tips}
                    </span>
                </div>
                <div class="form">
                    <%--                    <form action="login" method="post">--%>
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>
                            <span>用户名称:</span>
                            <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                                   tabindex="1" name="username" id="username"
                                   value="${requestScope.username}"
                            />
                        </label>
                        <label>
                            <span>用户密码:</span>
                            <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                                   tabindex="1" name="password" id="password"
                            />
                        </label>
                        <label>
                            <span>验证码:</span>
                            <input name="code" type="text" class="itxt y-middle">
                            <img class="imgcode y-middle " alt="图片码" src="kaptcha.jpg">
                        </label>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%-- 引入页脚 --%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>