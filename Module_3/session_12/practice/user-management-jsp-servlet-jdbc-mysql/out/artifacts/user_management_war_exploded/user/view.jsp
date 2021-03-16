<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16-Mar-21
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View User Information</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>User Information</h1>
    <fieldset>
        <legend>User information</legend>
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <td>${requestScope["user"].getId()}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${requestScope["user"].getName()}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${requestScope["user"].getEmail()}</td>
            </tr>
            <tr>
                <th>Country</th>
                <td>${requestScope["user"].getCountry()}</td>
            </tr>
            <tr>
                <td><a type="button" class="btn btn-info" href="/users">Back</a></td>
            </tr>
        </table>
    </fieldset>
</div>
</body>
</html>
