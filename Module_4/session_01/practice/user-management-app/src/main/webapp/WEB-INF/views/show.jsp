<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LIST CUSTOMER</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>List Customer</h1>
        <c:if test='${empty listCustomer}'>
            <h2>NO DATA</h2>
        </c:if>
        <c:if test='${not empty listCustomer}'>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>ADDRESS</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCustomer}" var="customer">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.address}</td>
                        <td>
                            <form action="/view" method="post">
                                <input type="number" name="customerId" value="${customer.id}" hidden>
                                <button class="btn btn-success btn-sm" type="submit">VIEW</button>
                            </form>
                        </td>
                        <td>
                            <form action="/showEdit" method="post">
                                <input type="number" name="customerId" value="${customer.id}" hidden>
                                <button class="btn btn-warning btn-sm" type="submit">EDIT</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td></td>
                        <td><a href="/"><button class="btn btn-info">BACK</button></a></td>
                    </tr>
                </tbody>
            </table>
        </c:if>

    </div>
</body>
</html>
