<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/11
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/account" method="post">
    <table>
        <tr>
            <td>转出方</td>
            <td><input type="text" name="fromuser"></td>
        </tr>
        <tr>
            <td>转入方</td>
            <td><input type="text" name="touser"></td>
        </tr>
        <tr>
            <td>转账金额</td>
            <td><input type="text" name="money"></td>
        </tr>
        <tr>
            <td><input type="submit" value="转账"></td>
        </tr>
    </table>

</form>
</body>
</html>
