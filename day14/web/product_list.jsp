<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center" width="88%">
    <tr>
        <th>pid</th>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>市场价</th>
        <th>商城价</th>
        <th>商品描述</th>
    </tr>
    <c:forEach items="${list }" var="p">
        <tr>
            <td>${p.pid}</td>
            <td>${p.pimage}</td>
            <td>${p.pname}</td>
            <td>${p.market_price}</td>
            <td>${p.shop_price}</td>
            <td>${p.pdesc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
