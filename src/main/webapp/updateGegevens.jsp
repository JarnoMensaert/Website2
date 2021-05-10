<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Update gegevens</title>
</head>
<body>

<h1 id="updateGegevens">Verandering gegevens</h1>

<form method="post" action="ProductInformatie?command=updateGegevens&productnaam=${param.productnaam}" novalidate>
    <p>
        Vul hier de nieuwe gegevens in.
    </p>
    <c:if test="${not empty param.naam}">
    <p>
        <label for="naam">Naam: </label><input
            id="naam" name="naam" type="text">
    </p>
    </c:if>
    <c:if test="${not empty param.voornaam}">
        <p>
            <label for="voornaam">Voornaam: </label><input
                id="voornaam" name="voornaam" type="text">
        </p>
    </c:if>
    <c:if test="${not empty param.prijs}">
        <p>
            <label for="prijs">Prijs: </label><input
                id="prijs" name="prijs" type="text">
        </p>
    </c:if>
    <p class="idform">
        <label for="verander">
            <input id="verander" type="submit" value="Verander gegevens">
        </label>
    </p>

    <input type="hidden" name="command" value="updateGegevens">

</form>

</body>
</html>
