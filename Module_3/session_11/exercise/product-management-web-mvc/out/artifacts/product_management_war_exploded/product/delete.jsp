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
    <title>Delete Product</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Delete Product</h1>
    <p><a href="/products">Back to Product list</a></p>
    <form method="post">
        <h3>Are you sure?</h3>
        <table class="table table-hover">
            <tr>
                <td scope="row">Name</td>
                <td>${requestScope["product"].getName()}</td>
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
            <tr>
                <td><input type="submit" value="Delete"></td>
                <td><a href="/products">Back to Product list</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
