<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl">
<head>
    <title>Logboek</title>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value="logboek"/>
</jsp:include>
<main id="container1">
<h1 id="overzichttekoop">
    Logboek
</h1>

    <c:choose>
        <c:when test="${not empty productnamen}">

            <div id="logboekproduct">
            <table id="overzicht">
                <tr>
                    <th>Productnaam</th>
                </tr>

                <c:forEach var="productnaam" items="${productnamen}">

                    <tr>
                        <td>${productnaam}</td>
                    </tr>
                </c:forEach>
            </table>
            </div>

        </c:when>

        <c:otherwise>
            <p>Je hebt nog geen producten opgezocht die succesvol waren.</p>
        </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
