<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 31-Mar-21
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div style="text-align: center" class="container col-6">
        <h1>Hello ${user.name} !</h1>
        <table class="table table-hover">
            <tr>
                <td>Name</td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Age</td>
                <td>${user.age}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Username</td>
                <td>${user.username}</td>
            </tr>
            <tr>
                <td>Password</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td></td>
                <td><a href="/"><button class="btn btn-info">Log out</button></a></td>
            </tr>
        </table>
    </div>
</body>
</html>
