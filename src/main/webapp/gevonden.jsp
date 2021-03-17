<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 14/03/2021
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Gevonden</title>
</head>
<body>

    <header>
        <div>
            <h1 id="titelheader">Gamingproducten verkoop</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="zoekForm.jsp">Zoek een product</a></li>
                    <li><a href="productForm.jsp">Verkoop een product</a></li>
                    <li><a href="ProductInformatie?command=overzicht">Producten te koop</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <main id="container1">
        <h1>Gevonden!</h1>
        <p id="boodschap">
            Je vroeg naar volgende gegevens: <%= request.getParameter("productnaam") %> <%= request.getParameter("prijs") %>
        </p>
    </main>

</body>
</html>
