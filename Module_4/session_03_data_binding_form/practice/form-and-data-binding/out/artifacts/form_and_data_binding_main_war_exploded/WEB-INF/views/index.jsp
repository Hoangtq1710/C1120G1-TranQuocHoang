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
    <title>Form and Data Binding</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center" class="container col-5">
    <h1>Add new Employee</h1>
    <form:form action="/create" method="post" modelAttribute="employee">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th><label for="id">ID</label></th>
                    <td>
                        <form:input path="id"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="name">Name</label></th>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <th><label for="phone">Phone</label></th>
                    <td>
                        <form:input path="phone"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-success">Save</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
