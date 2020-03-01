<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式--逻辑运算</title>
</head>
<body>
<h3>EL表达式--逻辑运算</h3>

<div>
    12 == 12 && 1 < 4: <br>
    ${12 == 12 && 1 < 4} 或 ${12 == 12 and 1 < 4} <br><br>

    12 != 12 || 1 < 4: <br>
    ${12 != 12 || 1 < 4} 或 ${12 != 12 or 1 < 4} <br><br>

    !false: <br>
    ${!false} 或 ${not false}


</div>
</body>
</html>
