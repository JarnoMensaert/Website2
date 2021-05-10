<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logbook</title>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value="logboek"/>
</jsp:include>
<main id="container1">
    <h1 id="overzichttekoop">
        Logbook
    </h1>

    <c:choose>
        <c:when test="${productnamen != null}">

            <div id="logboekproduct">
            <table id="overzicht">
                <tr>
                    <th>Product name</th>
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
            <p>You haven't searched a product that has been found.</p>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>
