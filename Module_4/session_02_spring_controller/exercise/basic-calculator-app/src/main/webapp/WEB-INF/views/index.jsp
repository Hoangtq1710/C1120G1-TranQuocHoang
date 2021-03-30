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
    <title>Calculator</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        input {
            width: 100%;
        }
    </style>
</head>
<body>
<div style="text-align: center" class="container col-6">
    <h1 style="color: darkblue">Calculator</h1>
    <form action="/calculator" method="post">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
            <tr>
                <th colspan="2">
                    <input type="text" name="first" placeholder="First" value="${first}">
                </th>
                <th colspan="2">
                    <input type="text" name="second" placeholder="Second" value="${second}">
                </th>
            </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-success" value="+" name="calculation">Addition</button>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-success" value="-" name="calculation">Subtraction</button>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-success" value="*" name="calculation">Multiplication</button>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-success" value="/" name="calculation">Division</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <c:if test='${calculation != null and message == null}'>
        <h3>Result ${first} ${calculation} ${second} = ${result}</h3>
    </c:if>
    <c:if test='${message != null}'>
        <h2 style="color: red">${message}</h2>
    </c:if>
</div>
</body>
</html>
