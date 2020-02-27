<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<jsp:include page="partials/head.jsp"/>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"/>
    <main>
        <c:if test="true">
            <h1>Welcome to index.jsp</h1>
        </c:if>
        <c:if test="false">
            <h1>single letter variable names are good</h1>
        </c:if>
    </main>
</body>
</html>
