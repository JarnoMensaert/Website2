<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Gamingproducts sellout</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value="home"/>
</jsp:include>

<main id="container1">
    <h1>What can you find?</h1>
    <p id="welkom">Welcome, on this site you can sell and buy second hand gaming product at very reasonable prices. We also have a store located in Geel</p>


<p><a href="ProductInformatie?command=showNederlands">Ik heb liever de website in het nederlands</a></p>
    <c:if test="${gemiddelde != null}">
    <h2>Average price</h2>
        <p>The average price of the products for sale is: ${gemiddelde} euro</p>
    </c:if>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
