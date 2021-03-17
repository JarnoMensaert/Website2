<%@ page import="java.util.Collection" %>
<%@ page import="domain.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 16/03/2021
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Overzicht producten</title>
</head>
<body>
    <header>
        <div>
            <h1 id="titelheader">Gamingproducten toevoegen</h1>
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
        <h1 id="overzichttekoop">Producten te koop</h1>
        <%
            Collection<Product> producten = (Collection<Product>) request.getAttribute("producten");
            if (producten != null) {
        %>
        <table id="overzicht">
            <tr>
                <th>Naam</th>
                <th>Voornaam</th>
                <th>Productnaam</th>
                <th>Prijs</th>
                <th>Verwijder</th>
            </tr>

            <%
                for (Product product : producten) {
            %>

            <tr>
                <td><%= product.getNaam() %></td>
                <td><%= product.getVoornaam() %></td>
                <td><%= product.getProductnaam() %></td>
                <td><%= product.getPrijs() %></td>
                <td><a href="ProductInformatie?command=verwijder&naam=<%= product.getNaam() %>&voornaam=<%= product.getVoornaam() %>&productnaam=<%= product.getProductnaam() %>">Verwijder</a></td>
            </tr>
            <%
                }
            %>
        </table>
            <%
                } else {
            %>
        <p>Er staan geen producten te koop.</p>
        <%
            }
        %>
    </main>
</body>
</html>
