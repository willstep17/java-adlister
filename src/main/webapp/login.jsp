
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
    <title>Title</title>
</head>
<body>
    <form method="POST" action="/login.jsp">
        <label for="username">Username: </label>
        <input id="username" name="username" type="text">
        <label for="password">Password: </label>
        <input id="password" name="password" type="password">
        <input type="submit">
    </form>
</body>
</html>
