<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Update info</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<main id="container1">
    <c:choose>
    <c:when test="${not empty errors}">
    <div class="alert alert-danger">
        <ul id="validatie">
            <c:forEach items="${errors}" var="error">
                <li>${error}</li><br>
            </c:forEach>
        </ul>
    </div>
    </c:when>
    <c:when test="${error != null}">
    <li id="validatie1">${error}</li>
    </c:when>
    </c:choose>

    <h1 id="update">Update a value of the product</h1>
    <form method="post" action="ProductInformatie?command=updateProduct&productnaam=${product.productnaam}" novalidate>
        <p id="updateproductinfo">
            Product information
        </p>
        <p class="form-group ${naamClass}">
            <label class="control-label" for="naam">Last name: </label><input
                id="naam" name="naam" type="text" value="${naamPreviousValue}">
        </p>
        <p class="form-group ${voornaamClass}">
            <label class="control-label" for="voornaam">First name: </label> <input
                id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
        </p>
        <p class="form-group ${prijsClass}">
            <label class="control-label" for="prijs">Price: </label><input
                id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
        </p>
        <p class="idform">
            <label for="updateProduct">
                <input id="updateProduct" type="submit" value="Update product">
            </label>
        </p>
    </form>
</main>
<jsp:include page="footer.jsp"/>
</body>