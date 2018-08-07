<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${3>4}">
        3大于4
    </c:if>

    <c:if test="${3<4}">
        3小于4
    </c:if>
</body>
</html>
