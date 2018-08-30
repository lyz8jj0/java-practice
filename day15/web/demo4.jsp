<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/30
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //页面加载成功 查询所有省
            $.get("/day15/selectPro", function (d) {
                // alert(d)
                var $pro = $("#proId");
                $(d).each(function () {
                    $pro.append("<option value=" + this.provinceid + ">" + this.name + "</option>")
                })
            }, "json");

            //给省份下拉选派发change事件
            $("#proId").change(function () {
                //获取省份id
                var $pid = $(this).val();
                //发送ajax请求 查询所有的市
                $.get("/day15/selectCity", {"pid": $pid}, function (obj) {
                    // alert(obj);
                    var $city = $("#cityId");
                    $city.html("<option>-请选择-</option>");
                    if (obj != null) {
                        $(obj).each(function () {
                            $city.append("<option value='" + this.cityid + "'>" + this.name + "</option>")
                        })
                    }
                }, "json");
            });
        })
    </script>
    <title>省市联动</title>
</head>
<body>
<select name="province" id="proId">
    <option>-省份-</option>
    <!-- 
     <option value="1">北京</option>
     -->
</select>
<select name="city" id="cityId">
    <option>-请选择-</option>
</select>
</body>
</html>
