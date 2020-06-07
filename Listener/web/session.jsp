<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="pages/common/head.jsp" %>
    <title>session监听器</title>
    <style type="text/css">
        .content {
            margin: 10px 0;
            padding: 10px;
            height: 400px;
            border: lightskyblue 1px solid;
        }
        .btn {
            margin: 5px 10px;
        }
    </style>
    <script>
        function addSession() {
            var session = null;
            $.getJSON(
                "sessionServlet",
                {action: "createSession"},
                function (data) {
                    console.log(data);
                    session = data;
                }
            );
            if (!session == null) {
                return;
            }
            getSessions();
        }

        /**
         * 获取所有服务器上所有存活的session对象，并渲染页面
         */
        function getSessions() {
            console.log("getSessions === ");
            var sessionsJson = null;
            $.getJSON(
                "sessionServlet",
                {action: "listSession"},
                function (data) {
                    console.log(data);
                    sessionsJson = data;
                    if (!sessionsJson || !sessionsJson.sessions) {
                        return;
                    }
                    $(".total").html(sessionsJson.total);
                    var _html = "";
                    $.each(sessionsJson.sessions, function (i, item) {
                        _html += "<li>";
                        _html += "<span class='session'>" + item + "</span>";
                        _html += "<button class='btn'>删除</button>";
                        _html += "</li>";
                        _html += "\n";
                    });
                    $(".sessionList").html(_html);
                }
            );
        }

        // 删除session，通过cookie的key JSESSIONID传相应的 session id到服务端
        function deleteSession() {
            $.get(
                "sessionServlet?action=deleteSession",
                function (data) {
                    getSessions();
                }
            );
        }

        // DOM就绪
        $(function () {
            // 首次打开页面时，加载session列表
            getSessions();

            // 绑定事件
            $(".addSession").on("click", function () {
                addSession();
            });

            // 删除session
            $(document).on("click", ".btn", deleteSession);
        });
    </script>
</head>
<body>
<h3>session监听器</h3>

<div>
    <button class="addSession">创建一个session</button>
</div>

<div class="content">
    <div>
        <p>创建多个cookie，打开浏览器的控制台，把cookie中key为JSESSIONID的记录删除，在点击 创建一个session 即可</p>
        <p>删除cookie，打开浏览器的控制台，把cookie中，key为JSESSIONID对应的值改成相应的session id，点击 删除 即可</p>
    </div>
    <div>
        共<span class="total"></span>个session
    </div>
    <div>
        <ul class="sessionList"></ul>
    </div>
</div>
</body>
</html>
