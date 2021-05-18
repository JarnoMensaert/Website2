<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Not found</title>
</head>
<body>

<jsp:include page="headerEN.jsp">
    <jsp:param name="actual" value=""/>
</jsp:include>

<main id="container1">
    <h1 id="nietgevonden">Not found...</h1>
    <p id="welkom">Unfortunately we did not find the product you were asking for.</p>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
