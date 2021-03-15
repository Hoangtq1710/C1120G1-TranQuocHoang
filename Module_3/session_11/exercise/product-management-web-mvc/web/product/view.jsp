<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 14-Mar-21
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Product Detail</h1>
    <p><a href="/products">Back to Product list</a></p>
    <table class="table table-hover">
        <tr>
            <td>Name</td>
            <td scope="row">${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${requestScope["product"].getDescription()}</td>
        </tr>
        <tr>
            <td>Manufacture</td>
            <td>${requestScope["product"].getManufacture()}</td>
        </tr>
    </table>
</div>
</body>
</html>
