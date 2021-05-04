<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 16/03/2021
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Gamingproduct toevoegen</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="voegToe"/>
    </jsp:include>

    <main id="container1">
        <h1 id="verkoopproduct">Verkoop een product</h1>
        <form method="post" action="ProductInformatie?command=voegToe">
            <p id="producttekoop">
                Product informatie
            </p>
            <p class="idform">
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
                    Prijs: <input id="prijs" name="prijs" type="text" value="" required>
                </label>
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
