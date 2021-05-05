<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Search a gaming product</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value="zoek"/>
</jsp:include>

<main id="container1">
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li><br>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <h1 id="zoekProduct">Search a product</h1>
    <form method="get" action="ProductInformatie?command=zoekProduct" novalidate>
        <p id="welkproduct">
            What product are you searching?
        </p>
        <p class="form-group ${naamClass}">
            <label class="control-label" for="naam">Last name: </label><input
                id="naam" name="naam" type="text" value="${naamPreviousValue}" required>
        </p>
        <p class="form-group ${voornaamClass}">
            <label class="control-label" for="voornaam">First name: </label> <input
                id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
        </p>
        <p class="form-group ${productnaamClass}">
            <label class="control-label" for="productnaam">Product name: </label><input
                id="productnaam" name="productnaam" type="text" value="${productnaamPreviousValue}">
        </p>
        <p class="form-group ${prijsClass}">
            <label class="control-label" for="prijs">Price: </label><input
                id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
        </p>
        <%--<p class="idform">
            <label for="naam">
                Naam: <input id="naam" name="naam" type="text" value="" required>
            </label>
        </p>
        <p class="idform">
            <label for="voornaam">
                Voornaam: <input id="voornaam" name="voornaam" type="text" value="" required>
            </label>
        </p>
        <p class="idform">
            <label for="productnaam">
                Productnaam: <input id="productnaam" name="productnaam" type="text" value="" required>
            </label>
        </p>
        <p class="idform">
            <label for="prijs">
                Prijs: <input id="prijs" name="prijs" type="number" value="" required>
            </label>
        </p> --%>
        <p class="idform">
            <label for="zoek">
                <input id="zoek" type="submit" value="Search product">
            </label>
        </p>

        <input type="hidden" name="command" value="zoekProduct">

    </form>
</main>
</body>
</html>