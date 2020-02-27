<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] hobbies = {"Archery", "Guns", "Tacos", "Cars"};
    request.setAttribute("hobbies", hobbies);
%>
<html>
<head>
    <jsp:include page="partials/head.jsp"/>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"/>
    <main>
        <h1>Profile Page</h1>
        <h3>Hobbies</h3>
        <c:forEach var="hobby" items="${hobbies}">
            <li>${hobby}</li>
        </c:forEach>
        <ul></ul>
    </main>
</body>
</html>
