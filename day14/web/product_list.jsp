<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center" width="88%">
    <tr>
        <td colspan="7">
            <form action="${pageContext.request.contextPath}/findProductByCondition" method="post">
                商品名称:<input name="name">&nbsp;&nbsp;&nbsp;&nbsp;关键词:<input name="kw">&nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询">
            </form>
        </td>
        <td colspan="1" align="right">
            <input type="button" value="删除选中" onclick="delCheck()">
        </td>
    </tr>
    <tr>
        <td><input type="checkbox" onclick="checkAll(this)"></td>
        <th>pid</th>
        <th>商品图片</th>
        <th>商品名称</th>
        <th>市场价</th>
        <th>商城价</th>
        <th>商品描述</th>
        <th>操作</th>
    </tr>
    <form id="formId" action="${pageContext.request.contextPath}/delCheckedServlet" method="post">
        <c:forEach items="${list }" var="p">
            <tr align="center">
                <td width="1%"><input type="checkbox" name="pid" value="${p.pid}"></td>
                <td width="8%">${p.pid}</td>
                <td width="8%"><img width="80" src="${pageContext.request.contextPath}/${p.pimage}" alt=""></td>
                <td width="8%">${p.pname}</td>
                <td width="8%">${p.market_price}</td>
                <td width="8%">${p.shop_price}</td>
                <td>${p.pdesc}</td>
                <td width="8%">
                    <a href="${pageContext.request.contextPath}/getProductById?pid=${p.pid}">修改</a>
                    |
                    <a href="javascript:void(0)" onclick="deleteP('${p.pid}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
<script type="text/javascript">
    /**
     * 删除商品
     * @param obj
     */
    function deleteP(obj) {
        // alert(obj);
        if (confirm("你真舍得丢弃我吗?")) {
            //发送请求
            location.href = "${pageContext.request.contextPath}/deleteProductById?pid=" + obj;
        }
    }


    //全选
    function checkAll(obj) {
        //获取所有复选框
        var arr = document.getElementsByName("pid");

        //遍历数组修改选中状态
        for (var i = 0; i < arr.length; i++) {
            arr[i].checked = obj.checked;
        }
    }

    //删除选中
    function delCheck() {
        //提交表单
        document.getElementById("formId").submit();

    }

</script>
</html>
