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
    <title>学生登录系统</title>
</head>
<body>
<h2>${message}</h2>
<form method="POST" action="${pageContext.request.contextPath}/login" >
    <table>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

