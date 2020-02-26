<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"></jsp:include>
<h1>Let's Play FizzBuzz!</h1>
<ul>
    <c:forEach var="i" begin="1" end="30">
        <c:choose>
            <c:when test="${i%15 == 0}">
                <li>FizzBuzz!</li>
            </c:when>
            <c:when test="${i%5 == 0}">
                <li>Buzz!</li>
            </c:when>
            <c:when test="${i%3 == 0}">
                <li>Fizz!</li>
            </c:when>
            <c:otherwise>
                <li>${i}</li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>
</body>
</html>
