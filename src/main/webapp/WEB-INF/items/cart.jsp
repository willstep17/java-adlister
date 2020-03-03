<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All Items In Store" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the items! Cart.</h1>
    <c:forEach var="item" items="${shoppingCart}">
        <div class="col-md-6">
            <h2>ID: ${item.id} Name: ${item.name}</h2>
            <p>${item.priceString}</p>
        </div>
    </c:forEach>
</div>
<div class="container">
    <h1>Total Cost: ${totalCost}</h1>
</div>

</body>
</html>
