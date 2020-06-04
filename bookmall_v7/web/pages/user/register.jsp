<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%-- 引入head相同部分 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <title>尚硅谷会员注册页面</title>

    <script type="text/javascript">
        // 刷新验证码
        function flushImgCode() {
            var time = (new Date()).getTime();
            $(".imgcode")[0].src = "kaptcha.jpg?v=" + time;
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

            // 获取确认密码
            var repwdValue = $("#repwd").val();
            // 验证确认密码和密码一致
            if (passwordValue != repwdValue) {
                // 提示用户
                alert("确认密码和密码不一致！");
                return false;
            }

            // 获取用户名
            var emailValue = $("#email").val();
            // 验证邮件输入是否合法。
            var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

            if (!emailReg.test(emailValue)) {
                // 提示用户
                alert("邮件输入不合法！");
                return false;
            }


            // 获取验证码信息
            var codeValue = $("#code").val();
            // 验证验证码不为空！
            if (codeValue == "") {
                alert("验证码不能为空！");
            }

            return true;
        }

        // 页面加载完成之后
        $(function () {

            // 给注册按钮添加事件
            $("#sub_btn").click(checkUser);

            // 刷新验证码
            $(".imgcode").click(flushImgCode);

            // 输入用户名后，验证用户名是否可用
            $("#username").blur(function () {  // 1. 给用户输入框绑定失去焦点事件
                // 2. 获取输入框中的用户名
                var username = this.value;
                // 3. 发起一个ajax请求到服务器，去验证用户是否存在
                $.post("userServlet",
                    "action=existUsername&username=" + username,
                    // 4. 接收服务器传回来的数据，显示在页面，用户是否可用
                    function (data) {
                        console.log(data);
                        if (data.exist) {
                            $(".errorMsg").html(username + "，用户名已经存在");
                        }
                    },
                    "json");
            });
        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>

<div id="login_header">
    <a href="">
        <img class="logo_img" alt="" src="static/img/logo.gif">
    </a>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%-- jsp代码脚本处理回显信息 --%>
<%--                        <%= request.getAttribute("tips") == null ? "" : request.getAttribute("tips") %>--%>

                        <%-- EL表达式方式处理 回显信息 --%>
                        ${requestScope.tips}
                    </span>
                </div>
                <div class="form">
                    <%--                    <form action="register" method="post">--%>
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>
                            用户名称:
                            <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                                   tabindex="1" name="username" id="username"
                                   value="${requestScope.user.username}"
                            />
                        </label>
                        <label>
                            用户密码:
                            <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                                   tabindex="1" name="password" id="password"
                                   value="${requestScope.user.password}"
                            />
                        </label>
                        <label>
                            确认密码:
                            <input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
                                   tabindex="1" name="repwd" id="repwd"
                                   value="${requestScope.user.password}"/>
                        </label>
                        <label>
                            电子邮件:
                            <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
                                   tabindex="1" name="email" id="email"
                                   value="${requestScope.user.email}"
                            />
                        </label>
                        <label>
                            验证码:
                            <input class="itxt" type="text" style="width: 100px;margin-left: 15px;"
                                   id="code" name="code"
                            />
                            <img class="imgcode" alt="验证码" src="kaptcha.jpg"
                                 style="float: right;  width: 100px; height:40px; margin-right: 62px;"
                            >
                        </label>
                        <input type="submit" value="注册" id="sub_btn"/>

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