<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 14-Mar-21
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Product List</h1>
    <p><a href="/products?action=create">Create new Product</a></p>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Manufacture</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items='${requestScope["products"]}' var="product">
                <tr>
                    <td scope="row" ><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDescription()}</td>
                    <td>${product.getManufacture()}</td>
                    <td><a href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                    <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
