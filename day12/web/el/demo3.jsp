<%@ page import="com.itheima.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u = new User();
    u.setId("001");
    u.setName("tom");
    u.setPassword("123");

    //将u放入域中
    request.setAttribute("user",u);
%>
获取域中JavaBean的id值：<br>
老方式：<%=((User)request.getAttribute("user")).getId()%><br>
el方式：${user.id}
</body>
</html>
