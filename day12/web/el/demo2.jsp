<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/6
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取复杂的数据</title>
</head>
<body>
<%
    //往request域中放入数组
    request.setAttribute("arr", new String[]{"aa", "bb", "cc"});

    //往request域中放入list
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list", list);

    //往request域中放入map
    Map m = new HashMap();
    m.put("username", "tom");
    m.put("age", 18);
    request.setAttribute("map", m);

    //往域中放入一个简单数据
    request.setAttribute("arr.age", "18");
%>
获取域中的数组：<br>
老方式：<%=((String[]) request.getAttribute("arr"))[1]%><br>
el方式：${arr[1]}<br>
<hr>

获取域中的数组：<br>
老方式：<%=((List) request.getAttribute("list")).get(1)%><br>
el方式：${list[1]}<br>
${list.size()}
<hr>

获取域中的数组：<br>
老方式：<%=((Map) request.getAttribute("map")).get("age")%><br>
el方式：${map.age}<br>
<hr>

获取特殊名字的数据：<br>
${requestScope["arr.age"]}
<hr>
</body>
</html>
