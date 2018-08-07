<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach begin="1" end="10" step="1" var="i">
    ${i}
</c:forEach>
<hr>
<c:forEach begin="1" end="20" step="2" var="i" varStatus="vs">
${i}--${vs.count}--${vs.current}<br>
</c:forEach>
</body>
</html>
