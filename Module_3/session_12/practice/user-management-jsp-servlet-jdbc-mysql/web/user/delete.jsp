<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 16-Mar-21
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete User</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h1>Are you sure?</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <fieldset>
        <legend>User Information</legend>
        <form method="post">
            <table class="table table-hover">
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
                    <th><button name="action" value="delete" hidden></button></th>
                    <td><input type="submit" value="Delete User"></td>
                    <td><a href="/users">Back to User List</a></td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
</body>
</html>
