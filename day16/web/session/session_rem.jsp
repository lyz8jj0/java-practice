<%@ page import="com.itheima.domain.Persion" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
将person对象从session中移除
<%
    session.removeAttribute("p");
%>
</body>
</html>
