<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th>操作</th>
    </tr>
    <c:forEach items="${pb.list}" var="p">
        <tr>
            <td width="8%">${p.pid}</td>
            <td width="8%"><img width="80" src="${pageContext.request.contextPath}/${p.pimage}" alt=""></td>
            <td width="8%">${p.pname}</td>
            <td width="8%">${p.market_price}</td>
            <td width="8%">${p.shop_price}</td>
            <td>${p.pdesc}</td>
        </tr>
    </c:forEach>

</table>
<center>
    <!-- 若是第一页,首页和上一面不展示 -->
    <c:if test="${pb.currPage!=1}">
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=1">[首页]</a>
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage-1}">[上一页]</a>
    </c:if>

    <!-- 将所有页码展示出来 -->
    <c:forEach begin="1" end="${pb.totalPage}" var="n">
        <!-- 若是当前页不可点-->
        <c:if test="${pb.currPage== n}">
            ${n}
        </c:if>
        <c:if test="${pb.currPage!=n}">
            <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${n}">${n}</a>
        </c:if>
    </c:forEach>

    <!-- 若是最后一页尾页和下一页不展示 -->
    <c:if test="${pb.currPage!=pb.totalPage}">
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.currPage+1}">[下一页]</a>
        <a href="${pageContext.request.contextPath}/showProductsByPage?currPage=${pb.totalPage}">[尾页]</a>
    </c:if>
    第${pb.currPage}页/共${pb.totalPage}页
</center>
</body>
</html>
