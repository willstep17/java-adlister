<%--
  Created by IntelliJ IDEA.
  User: williamstephens
  Date: 2/26/20
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
