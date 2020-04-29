<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示已上传的图片</title>
    <style type="text/css">
        .img-box {
            float: left;
            margin: 10px 20px;
        }

        .img-box .img {
            width: 300px;
        }

        .img-box button {
            display: block;
            margin: 5px auto;
        }

        .clearfix:before, .clearfix:after {
            display: table;
            content: "";
            clear: both;
        }
    </style>
</head>
<body>
<h3>展示已上传的图片</h3>

<div class="container clearfix">
    <c:forEach var="file" items="${requestScope.files}">
        <div class="img-box">
            <img class="img" src="${file}">
            <button>
                <a href="downloadServlet?url=/${file}">下载</a>
            </button>
        </div>
    </c:forEach>
</div>
</body>
</html>
