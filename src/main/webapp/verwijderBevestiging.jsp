<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Verwijder een product</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

<main id="container1">
    <article>
        <h2>Verwijder dit product</h2>

        <p>Ben je zeker dat je het product ${productnaam} van ${naam} ${voornaam} aan en prijs van ${prijs} wil verwijderen?</p>
        <form action="ProductInformatie?command=verwijderBevestiging&naam=${naam}&voornaam=${voornaam}&productnaam=${productnaam}&prijs=${prijs}" method="POST">
            <input id="zeker" type="submit" value="Zeker" name="bevestiging">
            <input id="tochniet" type="submit" value="Toch niet" name="geenbevestiging">
        </form>
    </article>
</main>

</body>
</html>
