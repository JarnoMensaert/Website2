<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Niet gevonden</title>
</head>
<body>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value=""/>
    </jsp:include>

    <main id="container1">
        <h1 id="nietgevonden">Niet gevonden...</h1>
        <p id="welkom">Spijtig genoeg is het product dat u zocht niet in de aanbieding</p>
    </main>
    <jsp:include page="footer.jsp"/>
</body>
</html>
