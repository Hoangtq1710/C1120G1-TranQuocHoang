<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 30-Mar-21
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Condiment</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>List Condiment</h2>
        <c:forEach items="${listCondiment}" var="condiment">
            <p>${condiment}</p>
        </c:forEach>
        <a href="/"><button class="btn btn-info">Back</button></a>
    </div>
</body>
</html>
