<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Gamingproduct toevoegen</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="voegToe"/>
    </jsp:include>

    <main id="container1">
        <c:choose>
            <c:when test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${errors}" var="error">
                            <li>${error}</li><br>
                        </c:forEach>
                    </ul>
                </div>
            </c:when>
            <c:when test="${error != null}">
                <li>${error}</li><br>
            </c:when>
        </c:choose>

        <h1 id="verkoopproduct">Verkoop een product</h1>
        <form method="post" action="ProductInformatie?command=voegToe" novalidate>
            <p id="producttekoop">
                Product informatie
            </p>
            <p class="form-group ${naamClass}">
                <label class="control-label" for="naam">Naam: </label><input
                    id="naam" name="naam" type="text" value="${naamPreviousValue}" required>
            </p>
            <p class="form-group ${voornaamClass}">
                <label class="control-label" for="voornaam">Voornaam: </label> <input
                    id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
            </p>
            <p class="form-group ${productnaamClass}">
                <label class="control-label" for="productnaam">Productnaam: </label><input
                    id="productnaam" name="productnaam" type="text" value="${productnaamPreviousValue}">
            </p>
            <p class="form-group ${prijsClass}">
                <label class="control-label" for="prijs">Prijs: </label><input
                    id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
            </p>
            <p class="idform">
                <label for="bewaar">
                    <input id="bewaar" type="submit" value="Voeg product toe">
                </label>
            </p>

            <input type="hidden" name="command" value="voegToe">

        </form>
    </main>
</body>
</html>
