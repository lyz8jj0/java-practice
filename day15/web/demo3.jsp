<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#tid").keyup(function () {
                //获取文本框的值
                var $value = $(this).val();

                //内容为空的时候不发送ajax
                if ($value != null || $value != '') {
                    $("#did").html("");
                    $.post("/day15/searchKw", "kw=" + $value, function (d) {
                        if (d != '') {
                            var arr = d.split(",");
                            $(arr).each(function () {
                                //可以将每一个值放入一个div 将其内部插入为id为did的div中
                                $("#did").append($("<div>" + this + "</div>"))
                            });
                            //将idv显示
                            $("#did").show()
                        }
                    })
                } else {
                    //将div隐藏
                    $("#did").hide()

                }
            })
        })

    </script>
</head>
<body>
<center>
    <h1>黑马搜索</h1>
    <div>
        <input type="text" id="tid" name="kw"><input type="submit" value="黑马一下">
    </div>
    <div id="did" style="border: 1px solid red;width: 171px;position: relative;left: -34px;display: none"></div>
</center>
</body>
</html>
