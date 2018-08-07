<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高级用法</title>
</head>
<body>
<%
    //往域中放入一个list
    List l = new ArrayList();
    l.add(11);
    l.add(22);
    l.add(33);
    request.setAttribute("list", l);

    //往域中放入一个set
    Set s = new HashSet();
    s.add("11");
    s.add("22");
    s.add("33");
    request.setAttribute("set", s);

    //往域中放入一个map
    Map m = new HashMap();
    m.put("username", "tom");
    m.put("age", 18);
    request.setAttribute("map", m);
%>
<c:forEach items="${list}" var="n">
    ${n}
</c:forEach>
<hr>
<c:forEach items="${set}" var="n" varStatus="vs">
    ${n}--${vs.count}
</c:forEach>
<hr>
<c:forEach items="${map}" var="en">
    ${en.key}--${en.value}<br>
</c:forEach>
<!--
    for(Integer n :list){
        i
    }
-->

</body>
</html>
