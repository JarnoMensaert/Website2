<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Gamingproducten verkoop</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="home"/>
    </jsp:include>

    <main id="container1">
        <h1>Wat kan je vinden?</h1>
        <p id="welkom">Welkom, op deze website kan je tweedehands gamingproducten kopen en verkopen aan zeer goede prijzen.</p>


    <p><a href="ProductInformatie?command=showEnglish">EN</a></p>
<%--
Als er op deze link geclickt wordt, zal er in de url command=showEnglish staan.
We navigeren dan naar de servlet met command=showEnglish
--%>
    <h2>Logboek?</h2>
    <p>Wilt u een logboek van uw opgezochte personen onthouden?</p>
    <form action="ProductInformatie?command=logboek" method="POST">
        <input type="submit" value="Ja" name="bevestiging">
        <input type="submit" value="Nee" name="geenbevestiging">
    </form>
        <h2>Gemiddelde prijs</h2>
        <c:if test="${gemiddelde != null}">
            <p>De gemiddelde prijs van alle producten die in de aanbieding staan is: ${gemiddelde} euro</p>
        </c:if>
    </main>

</body>
</html>
