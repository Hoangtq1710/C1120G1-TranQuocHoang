<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Information</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <table class="table table-hover">
            <h1>Customer Information</h1>
            <tbody>
                <tr>
                    <th>ID</th>
                    <td>${customer.id}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${customer.name}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${customer.email}</td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>${customer.address}</td>
                </tr>
                <tr>
                    <th></th>
                    <td><a href="/customer"><button class="btn btn-info btn-sm">BACK</button></a></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
