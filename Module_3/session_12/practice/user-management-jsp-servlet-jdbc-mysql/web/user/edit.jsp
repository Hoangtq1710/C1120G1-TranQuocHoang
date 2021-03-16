<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16-Mar-21
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Information</title>
    <meta charset="UTF-8">
    <style>
        .message {
            color: green;
        }
    </style>
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Edit User Information</h1>
    <p><a href="/users">Back to User List</a></p>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <c:if test='${requestScope["user"] != null}'>
            <input type="hidden" name="id" value="${requestScope["user"].getId()}">
        </c:if>
    </p>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" id="name" value="${requestScope["user"].getName()}"></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" id="email" value="${requestScope["user"].getEmail()}"></td>
            </tr>
            <tr>
                <th>Country</th>
                <td><input type="text" name="country" id="country" value="${requestScope["user"].getCountry()}"></td>
            </tr>
            <tr>
                <th><button name="action" value="edit" hidden></button></th>
                <td><input type="submit" value="Update User"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
