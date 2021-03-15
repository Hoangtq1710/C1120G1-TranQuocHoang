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
    <meta charset="UTF-8">
    <title>Create new Product</title>
    <style>
        .message {
            color: green;
        }
    </style>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Create new Product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">Back to Product list</a>
    </p>
    <form method="post">
        <fieldset>
            <legend>Product Information</legend>
            <table>
                <tr>
                    <td scope="row">Name</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" id="price"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" id="description"></td>
                </tr>
                <tr>
                    <td>Manufacture</td>
                    <td><input type="text" name="manufacture" id="manufacture"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
