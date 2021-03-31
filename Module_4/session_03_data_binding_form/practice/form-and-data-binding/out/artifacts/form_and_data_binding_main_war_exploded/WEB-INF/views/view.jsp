<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 31-Mar-21
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee Information</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container col-6">
        <h1>Employee Information</h1>
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th>ID</th>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>${employee.name}</td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>${employee.phone}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="/"><button class="btn btn-info">Back</button></a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
