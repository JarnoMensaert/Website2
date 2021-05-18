<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Found</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<main id="container1">
    <h1 id="gevonden">Found!</h1>
    <p id="boodschap">
        You asked for the following product: ${param.productnaam} ${param.prijs} euro
    </p>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
