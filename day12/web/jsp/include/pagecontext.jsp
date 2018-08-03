<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pagecontext操作其他域对象</title>
</head>
<body>
<%
    pageContext.setAttribute("rkey", "rvalue", PageContext.REQUEST_SCOPE);
%>
通过pagecontext往request中放入一个值，取出来：<%=request.getAttribute("rkey")%>
</body>
</html>
