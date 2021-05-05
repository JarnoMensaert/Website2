<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 16/03/2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
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
    <p id="welkom">Welcom, on this site you can sell and buy second hand gaming product at very reasonable prices</p>
</main>

<p><a href="ProductInformatie?command=showNederlands">NL</a></p>

</body>
</html>
