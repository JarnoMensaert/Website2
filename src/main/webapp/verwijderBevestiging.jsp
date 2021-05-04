<%--
  Created by IntelliJ IDEA.
  User: mensa
  Date: 5/4/2021
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Verwijder een product</title>
</head>
<body>

<main id="container1">
    <article>
        <h2>Verwijder dit product</h2>

        <p>Ben je zeker dat je het product ...... wil verwijderen?</p>
        <form action="ProductInformatie?command=verwijder" method="POST">
            <input type="submit" value="Zeker" name="bevestiging">
            <input type="submit" value="Toch niet" name="geenbevestiging">
        </form>
    </article>
</main>

</body>
</html>
