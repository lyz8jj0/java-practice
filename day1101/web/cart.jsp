<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/1
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<table border="1" align="center" width="">
    <tr>
        <td>商品名称</td>
        <td>商品数量</td>
    </tr>
    <%
        //1，获取购物车
        Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");

        //2，判断购物车是否为空
        if (map == null) {
            //2.1若不为空：亲，购物车空空，先去逛逛~~
            out.print("<tr><td colspan='2'>亲，购物车空空，先去逛逛~~~</td></tr>");
        } else {
            //2.2若不为空：遍历购物车
            for (String name : map.keySet()) {
                out.print("<tr>");
                out.print("<td>");
                out.print(name);
                out.print("</td>");
                out.print("<td>");
                out.print(map.get(name));
                out.print("</td>");
                out.print("</tr>");
            }
        }
    %>
</table>
<hr>
<center>
    <a href="/day1101/product_list.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;
    <a href="/day1101/clearCart">清空购物车</a>&nbsp;&nbsp;&nbsp;

</center>
</body>
</html>
