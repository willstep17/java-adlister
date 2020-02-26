<%--
  Created by IntelliJ IDEA.
  User: williamstephens
  Date: 2/26/20
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int counter = 0; %>
<% counter++; %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        if (request.getParameter("reset") != null) {
            counter = Integer.parseInt(request.getParameter("reset"));
        }
    %>
<%--    <% request.setAttribute("message", "you have a message"); %>--%>


    <h1>The current count is <%= counter %>.</h1>

    <p>Path: <%= request.getRequestURL() %></p>
    <p>Query String: <%= request.getQueryString() %></p>
    <p>"name" parameter: <%= request.getParameter("name") %></p>
    <p>"method" attribute: <%= request.getMethod() %></p>
    <p>User-Agent header: <%= request.getHeader("user-agent") %></p>
</body>
</html>
