<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 14/03/2021
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Gevonden</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

    <main id="container1">
        <h1>Gevonden!</h1>
        <p id="boodschap">
            Je vroeg naar volgende gegevens: ${productnaam} ${prijs} euro
        </p>
    </main>

</body>
</html>
