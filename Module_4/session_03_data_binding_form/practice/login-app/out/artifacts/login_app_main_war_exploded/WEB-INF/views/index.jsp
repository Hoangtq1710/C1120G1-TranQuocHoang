<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center" class="container col-5">
    <h1 style="color: teal">Login Form</h1>
    <form:form action="login" method="post" modelAttribute="login">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <td>
                        <form:label path="username">Username</form:label>
                    </td>
                    <td>
                        <form:input path="username"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="password">Password</form:label>
                    </td>
                    <td>
                        <form:input path="password"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button class="btn btn-success" type="submit">Log in</button>
                    </td>
                </tr>
            <c:if test="${message != null}">
                <tr>
                    <td colspan="2">
                        <span style="color: brown">${message}</span>
                    </td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
