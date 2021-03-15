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
    <title>Edit Product</title>
    <style>
        .message {
            color: green;
        }
    </style>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Edit Product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to Product</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Product Information</legend>
            <table class="table table-hover">
                <tr>
                    <td scope="row">Name</td>
                    <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" id="description" value="${requestScope["product"].getDescription()}"></td>
                </tr>
                <tr>
                    <td>Manufacture</td>
                    <td><input type="text" name="manufacture" id="manufacture" value="${requestScope["product"].getManufacture()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update Product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
