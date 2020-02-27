<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    if(request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
<jsp:include page="partials/head.jsp"/>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"/>
    <main>
        <form method="POST" action="/login.jsp">
            <label class="form-label" for="username">Username</label>
            <input id="username" name="username" type="text">
            <label class="form-label" for="password">Password</label>
            <input id="password" name="password" type="password">
            <button type="submit">Log In</button>
        </form>
    </main>
</body>
</html>
