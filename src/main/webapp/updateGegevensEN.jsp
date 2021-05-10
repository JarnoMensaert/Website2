<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Update information</title>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<h1 id="updateGegevens">Change information</h1>

<form method="post" action="ProductInformatie?command=updateGegevens&productnaam=${param.productnaam}" novalidate>
    <p>
        Enter the new information here.
    </p>
    <c:if test="${not empty param.naam}">
        <p class="form-group ${naamClass}">
            <label class="control-label"  for="naam">Last name: </label><input
                id="naam" name="naam" type="text" value="${naamPreviousValue}">
        </p>
    </c:if>
    <c:if test="${not empty param.voornaam}">
        <p class="form-group ${voornaamClass}">
            <label class="control-label" for="voornaam">First name: </label><input
                id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
        </p>
    </c:if>
    <c:if test="${not empty param.prijs}">
        <p class="form-group ${prijsClass}">
            <label class="control-label" for="prijs">Price: </label><input
                id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
        </p>
    </c:if>
    <p class="idform">
        <label for="verander">
            <input id="verander" type="submit" value="Change information">
        </label>
    </p>

    <input type="hidden" name="command" value="updateGegevens">

</form>

</body>
</html>
