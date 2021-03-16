<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15-Mar-21
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>User Management</h1>
    <p><a href="/users?action=create">Create new User</a></p>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Options</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td><a href="/users?action=view&id=${user.getId()}">${user.getName()}</a></td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getCountry()}</td>
                    <td>
                        <button><a href="/users?action=edit&id=${user.getId()}">Edit</a></button>
                        <button><a href="/users?action=delete&id=${user.getId()}">Delete</a></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
