<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logbook</title>
    <link rel="stylesheet" href="css/style.css">
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
        </c:when>

        <c:otherwise>
            <p>You haven't searched a product that has been found.</p>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>
