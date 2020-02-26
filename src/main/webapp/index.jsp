<%--
  Created by IntelliJ IDEA.
  User: williamstephens
  Date: 2/26/20
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <h1>The current count is <%= counter %>.</h1>
</body>
</html>
