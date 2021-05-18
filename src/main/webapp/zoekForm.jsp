<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Zoek een gamingproduct</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="zoek"/>
    </jsp:include>

    <main id="container1">
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul id="validatie">
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li><br>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h1 id="zoekProduct">Zoek een product</h1>
        <form method="get" action="ProductInformatie?command=zoekProduct" novalidate>
            <p id="welkproduct">
                Welk product zoek je?
            </p>
            <p class="form-group ${naamClass}">
                <label class="control-label" for="naam">Naam: </label><input
                    id="naam" name="naam" type="text" value="${naamPreviousValue}" required>
            </p>
            <p class="form-group ${voornaamClass}">
                <label class="control-label" for="voornaam">Voornaam: </label> <input
                    id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
            </p>
            <p class="form-group ${productnaamClass}">
                <label class="control-label" for="productnaam">Productnaam: </label><input
                    id="productnaam" name="productnaam" type="text" value="${productnaamPreviousValue}">
            </p>
            <p class="form-group ${prijsClass}">
                <label class="control-label" for="prijs">Prijs: </label><input
                    id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
            </p>
            <p class="idform">
                <label for="zoek">
                    <input id="zoek" type="submit" value="Zoek product">
                </label>
            </p>

            <input type="hidden" name="command" value="zoekProduct">

        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</body>
</html>
