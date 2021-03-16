<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15-Mar-21
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New User</title>
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
    <h1>Create New User</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p><a href="/users">Back to User List</a></p>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <th>Country</th>
                <td><input type="text" name="country" id="country"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create User"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
