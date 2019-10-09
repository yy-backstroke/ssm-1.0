<%--
  Created by IntelliJ IDEA.
  User: 11103360
  Date: 2019/9/5
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>登录有误</title>
</head>
<body>

<h2>登录信息有误</h2>
<form method="GET" >
    <table>
        <tr>
            <td>${message}</td>
        </tr>
        <tr>
            <td>
                <input type="button" value="重新登录"
                       onclick="window.location.href='/login'"/>
                <input type="button" value="立即注册"
                       onclick="window.location.href='/register'"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

