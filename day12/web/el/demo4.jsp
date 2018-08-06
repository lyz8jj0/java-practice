<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itheima.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("i", 3);
    request.setAttribute("j",4);
    request.setAttribute("q", "12");
    request.setAttribute("k", "k");

    List l = null;
    request.setAttribute("list",l);

    List ll = new ArrayList();
    ll.add("22");
    request.setAttribute("list_",ll);

    User user = null;
    request.setAttribute("bean",user);

    User user_ = new User();
    request.setAttribute("bean_",user_);
%>
${i+j}<br>
${i+q}<br>
<hr>
域中list的长度是否为0：${empty list}<br>
域中list_的长度是否为0：${empty list_}<br>
<hr>

域中的bean是否为空：${empty bean}<br>
域中的bean_是否为空：${empty bean_}<br>
</body>
</html>
