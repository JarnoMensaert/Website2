<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Remove a product</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<main id="container1">
    <article>
        <h2>Remove this product</h2>

        <p>Are you sure you want to remove ${productnaam} from ${naam} ${voornaam} at a price of ${prijs} euro?</p>
        <form action="ProductInformatie?command=verwijderBevestiging&naam=${naam}&voornaam=${voornaam}&productnaam=${productnaam}&prijs=${prijs}" method="POST">
            <input id="zeker" type="submit" value="Yes" name="bevestiging">
            <input id="tochniet" type="submit" value="Not" name="geenbevestiging">
        </form>
    </article>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
