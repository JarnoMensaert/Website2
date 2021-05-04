<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 16/03/2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Zoek een gamingproduct</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="zoek"/>
    </jsp:include>

    <main id="container1">
        <h1>Zoek een product</h1>
        <form method="get" action="ProductInformatie?command=zoekProduct">
            <p id="welkproduct">
                Welk product zoek je?
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
                    Prijs: <input id="prijs" name="prijs" type="number" value="" required>
                </label>
            </p>
            <p class="idform">
                <label for="zoek">
                    <input id="zoek" type="submit" value="Zoek product">
                </label>
            </p>

            <input type="hidden" name="command" value="zoekProduct">

        </form>
    </main>
</body>
</html>
