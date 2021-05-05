<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Gamingproducts sellout</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value="home"/>
</jsp:include>

<main id="container1">
    <h1>What can you find?</h1>
    <p id="welkom">Welcome, on this site you can sell and buy second hand gaming product at very reasonable prices</p>


<p><a href="ProductInformatie?command=showNederlands">NL</a></p>
<h2>Logbook?</h2>
<p>Do you want to keep a logbook of your product searches?</p>
<form action="ProductInformatie?command=logboek" method="POST">
    <input type="submit" value="Yes" name="bevestiging">
    <input type="submit" value="No" name="geenbevestiging">
</form>
    <h2>Average price</h2>
    <c:if test="${gemiddelde != null}">
        <p>The average price of the products for sale is: ${gemiddelde} euro</p>
    </c:if>
</main>

</body>
</html>
