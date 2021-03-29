<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Edit Info</h1>
        <form action="/edit" method="post">
            <table class="table table-hover">
                <thead></thead>
                <tbody>
                <tr hidden>
                    <th><label for="id">ID</label></th>
                    <td>
                        <input type="text" name="id" id="id" value="${customer.id}">
                    </td>
                </tr>
                <tr>
                    <th><label for="name">Name</label></th>
                    <td>
                        <input type="text" name="name" id="name" value="${customer.name}">
                    </td>
                </tr>
                <tr>
                    <th><label for="email">Email</label></th>
                    <td>
                        <input type="text" name="email" id="email" value="${customer.email}">
                    </td>
                </tr>
                <tr>
                    <th><label for="address">Address</label></th>
                    <td>
                        <input type="text" name="address" id="address" value="${customer.address}">
                    </td>
                </tr>
                <tr>
                    <td><a href="/customer"><button class="btn btn-info btn-sm">BACK</button></a></td>
                    <td><button class="btn btn-warning btn-sm" type="submit">UPDATE</button></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
