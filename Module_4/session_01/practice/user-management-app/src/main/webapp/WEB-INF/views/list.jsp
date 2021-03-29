<%@ page import="java.util.List" %>
<%@ page import="com.soren.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 26-Mar-21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../assert/style/bootstrap/css/bootstrap.min.css">

</head>
<body>
    <p>List Customer</p>

    <div class="container">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                </tr>
                <c:forEach items='${listCustomer}' var="customer">
                    <tr>
                        <td>${customer.getId()}</td>
                        <td>${customer.getName()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getAddress()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="customers"><button>BACK</button></a>
</body>
</html>
