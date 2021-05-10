<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Update keuze</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<h1 id="updateproduct">Update een product</h1>
<form method="get" action="ProductInformatie?command=updateKeuze&productnaam=${productnaam}" novalidate>
    <p id="producttekoop">
        Welke velden van ${param.productnaam} wil je veranderen?
    </p>
    <p>
        <label for="naam">Naam</label>
        <input id="naam" name="naam" type="radio" value="naam">
    </p>
    <p>
        <label for="voornaam">Voornaam</label>
        <input id="voornaam" name="voornaam" type="radio" value="voornaam">
    </p>
    <p>
        <label for="prijs">Prijs</label>
        <input id="prijs" name="prijs" type="radio" value="prijs">
    </p>
    <p class="idform">
        <label for="bevestig">
            <input id="bevestig" type="submit" value="Bevestigen">
        </label>
    </p>

    <input type="hidden" name="command" value="updateKeuze">
    <input type="hidden" name="productnaam" value="${param.productnaam}">

</form>

</body>
</html>
