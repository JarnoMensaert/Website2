<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Overzicht producten</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="overzicht"/>
    </jsp:include>

    <main id="container1">
        <h1 id="overzichttekoop">Producten te koop</h1>
        <c:choose>
            <c:when test="${producten != null}">
        <div style="overflow-x: auto">
        <table id="overzicht">
            <tr>
                <th>Naam</th>
                <th>Voornaam</th>
                <th>Productnaam</th>
                <th>Prijs</th>
                <th>Verwijder</th>
                <th>Update</th>
            </tr>

            <c:forEach var="product" items="${producten}">

            <tr>
                <td>${product.naam}</td>
                <td>${product.voornaam}</td>
                <td>${product.productnaam}</td>
                <td>${product.prijs}</td>
                <td><a id="verwijder" href="ProductInformatie?command=verwijder&naam=${product.naam}&voornaam=${product.voornaam}&productnaam=${product.productnaam}&prijs=${product.prijs}">Verwijder</a></td>
                <td><a id="update" href="ProductInformatie?command=update&productnaam=${product.productnaam}">Update</a></td>
            </tr>
                </c:forEach>
        </table>
        </div>
            </c:when>

            <c:otherwise>
                <p>Er staan geen producten te koop.</p>
            </c:otherwise>
        </c:choose>

    </main>
</body>
</html>
