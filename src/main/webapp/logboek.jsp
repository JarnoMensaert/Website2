<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logboek</title>
    <link rel="stylesheet" href="css/style.css">
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
        <c:when test="${productnamen != null}">

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
        </c:when>

        <c:otherwise>
            <p>Je hebt nog geen producten opgezocht die succesvol waren.</p>
        </c:otherwise>
    </c:choose>
</main>

</body>
</html>
