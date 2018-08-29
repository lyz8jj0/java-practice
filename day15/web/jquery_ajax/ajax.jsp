<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<html>
<head>
    <!-- load方式 -->
    <%--<script type="text/javascript">--%>
        <%--$(function () { //派发事件--%>
            <%--$("#btn").click(function () {--%>
                <%--var url = "/day15/jqueryAjax";--%>
                <%--var params = {"username":"张四"};--%>
                <%--$(this).load(url, params, function (d) {--%>
                    <%--alert(d)--%>
                <%--})--%>
            <%--})--%>
        <%--})--%>
    <%--</script>--%>


        <%--<!-- get方式 -->--%>
        <%--<script type="text/javascript">--%>
            <%--$(function () { //派发事件--%>
                <%--$("#btn").click(function () {--%>
                    <%--var url = "/day15/jqueryAjax";--%>
                    <%--var params = {"username":"张四"};--%>
                    <%--$.get(url, params, function (d) {--%>
                        <%--alert(d)--%>
                    <%--})--%>
                <%--})--%>
            <%--})--%>
        <%--</script>--%>

        <!-- post方式 -->
        <script type="text/javascript">
            $(function () { //派发事件
                $("#btn").click(function () {
                    var url = "/day15/jqueryAjax";
                    var params = {"username":"张四"};
                    $.post(url, params, function (d) {
                        alert(d.msg)
                    },"json")
                })
            })
        </script>

        <!-- ajax方式 -->
        <script type="text/javascript">
            $(function () { //派发事件
                $("#btn").click(function () {
                    var url = "/day15/jqueryAjax";
                    var params = {"username":"张四"};
                    $.ajax({
                        url:url,
                        type:"post",
                        data:params,
                        success:function (d) {
                            alert(d.msg)
                        },
                        error:function () {},
                        dataType:"json"

                    })
                })
            })
        </script>
    <title>Title</title>
</head>
<body>
<input type="button" id="btn" value="点我">
</body>
</html>
