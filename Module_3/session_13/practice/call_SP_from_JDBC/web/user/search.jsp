<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16-Mar-21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search User</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>User Management</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${listUser}' var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
            </tr>
        </c:forEach>
        <tr>
            <td><a type="button" class="btn btn-info" href="/users">Back</a></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
