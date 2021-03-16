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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1><a style="text-decoration: none;" href="/users">User Management</a></h1>
    <p><a href="/users?action=create"><i class="fas fa-plus"></i> Create new User</a></p>
    <form method="get" style="float: right; width: 250px" class="input-group">
        <input type="text" name="country" id="search" class="form-control" placeholder="Search ...">
        <div class="input-group-append">
            <button type="submit" class="btn btn-outline-info"><i class="fas fa-search"></i></button>
            <input name="action" value="search" hidden>
        </div>
    </form>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name
                    <a href="/users?action=sort&sortBy=${"asc"}"><i class="fas fa-sort-alpha-down"></i></a>
                    <a href="/users?action=sort&sortBy=${"desc"}"><i class="fas fa-sort-alpha-up"></i></a>
                </th>
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
                        <a type="button" class="btn btn-warning" href="/users?action=edit&id=${user.getId()}"><i class="fas fa-edit"></i></a>
                        <a type="button" class="btn btn-danger" href="/users?action=delete&id=${user.getId()}"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
