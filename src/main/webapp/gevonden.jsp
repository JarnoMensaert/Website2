<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Gevonden</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

    <main id="container1">
        <h1 id="gevonden">Gevonden!</h1>
        <p id="boodschap">
            Je vroeg naar volgende gegevens: ${param.productnaam} ${param.prijs} euro
        </p>
    </main>
    <jsp:include page="footer.jsp"/>
</body>
</html>
