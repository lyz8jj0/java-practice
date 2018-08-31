<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/31
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" value="${cookie.savename.value}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td colspan="1"><input type="checkbox" name="saveName" value="ok">记住用户名</td>
            <td colspan="1"><input type="checkbox" name="autoLogin" value="ok">自动登录</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>


</form>
</body>
</html>
