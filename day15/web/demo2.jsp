<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <title>Title</title>
</head>
<script type="text/javascript">
    $(function () {
        //给username派发一个失去焦点事件发送ajax请求
        $("input[name='username']").blur(function () {
            //获取输入的值
            var $value = $(this).val();
            // alert($value)

            $.get("/day15/checkUsername4Ajax", "username=" + $value, function (d) {
                // alert(d);
                if (d == 1) {
                    $("#username_msg").html("<font color='green'>用户名可以使用</font>");
                } else {
                    $("#username_msg").html("<font color='red'>用户名已被使用</font>");
                }
            })

        })
    })
</script>
<body>
<form action="#" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
            <td><span id="username_msg"></span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password"></td>
            <td></td>
        </tr>
    </table>
    <tr aria-colspan="3"><input type="submit" id="sub"></tr>

</form>
</body>
</html>
