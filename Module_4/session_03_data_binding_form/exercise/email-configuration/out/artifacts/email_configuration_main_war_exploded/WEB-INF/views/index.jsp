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
    <title>Email Configuration</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center" class="container col-7">
    <h1>Settings</h1>
    <form:form action="/email" method="post" modelAttribute="email">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th><label for="language">Languages</label></th>
                    <td><form:select path="language" items="${listLanguage}"/></td>
                </tr>
                <tr>
                    <th><label for="pageSize">Page Size</label></th>
                    <td>
                        <span>Show </span>
                        <form:select path="pageSize" items="${listPageSize}"/>
                        <span> emails per page</span>
                    </td>
                </tr>
                <tr>
                    <th><label>Spam Filter</label></th>
                    <td>
                        <form:checkbox path="spamFilter"/>
                        <label>Enable spams filter</label>
                    </td>
                </tr>
                <tr>
                    <th><label>Signature</label></th>
                    <td>
                        <form:textarea path="signature" cssStyle="width: 100%" rows="4" cols="20"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" class="btn btn-info">Back</button>
                    </td>
                    <td>
                        <button class="btn btn-warning" type="submit">Save</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form:form>
</div>
</body>
</html>
