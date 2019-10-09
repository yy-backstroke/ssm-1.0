<%--
  Created by IntelliJ IDEA.
  User: 11103360
  Date: 2019/9/2
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>学生信息详情</title>
</head>
<body>

<h2>--学生信息如下--</h2>
<form:form method="POST" action="/updateStudent" >
    <table>
        <tr>
            <td>学号：</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确认修改学生信息"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="id" value=${id} />
</form:form>
</body>
</html>
