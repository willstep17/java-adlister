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
    <h1>Here Are all the items! Store.</h1>

    <c:forEach var="item" items="${items}">
        <div class="col-md-6">
            <h2>ID: ${item.id} Name: ${item.name}</h2>
            <p>${item.priceString}</p>
            <form method="POST" action="/items/cart">
                <input type="hidden" name="id" value="${item.id}">
                <input type="hidden" name="name" value="${item.name}">
                <input type="hidden" name="priceInCents" value="${item.priceInCents}">
                <button>Add Item To Cart</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
