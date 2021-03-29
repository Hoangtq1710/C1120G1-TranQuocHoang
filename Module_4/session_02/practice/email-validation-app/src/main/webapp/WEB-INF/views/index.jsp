<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Email Validation</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container" style="margin-top: 20px">
        <h1>Email Validation</h1>
        <form action="/email" method="get">
            <table class="table table-hover">
                <thead></thead>
                <tbody>
                    <tr>
                        <th><label for="email">EMAIL</label></th>
                        <th><input type="text" id="email" name="email" value="${email}"></th>
                    </tr>
                    <tr>
                        <td></td>
                        <td><button class="btn btn-success btn-sm" type="submit">CHECK</button></td>
                    </tr>
                    <c:if test='${not empty message}'>
                        <tr>
                            <td></td>
                            <td><span style="color: red">${message}</span></td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
