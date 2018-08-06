<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("rkey", "rvalue");
    session.setAttribute("skey", "svalue");
    application.setAttribute("akey", "avalue");
%>
获取requset中的数据：<br>
老方式:<%=request.getAttribute("rkey")%><br/>
el方式:${requestScope.rekey}<br/>
<hr>

获取session中的数据：<br>
老方式:<%=session.getAttribute("skey")%><br/>
el方式:${sessionScope.skey}<br/>
<hr>

获取application中的数据：<br>
老方式:<%=application.getAttribute("akey")%><br/>
el方式:${applicationScope.akey}<br/>
<hr>

获取失败老方式:<%=application.getAttribute("aakey")%><br/>
获取失败el方式:${applicationScope.aakey}<br/>
<hr>

便捷获取
${skey},${rkey}
</body>
</html>
