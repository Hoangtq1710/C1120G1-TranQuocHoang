<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 31-Mar-21
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Email Configuration</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container col-6">
        <h1>Settings</h1>
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th>Language</th>
                    <td>${email.language}</td>
                </tr>
                <tr>
                    <th>Page Size</th>
                    <td>${email.pageSize}</td>
                </tr>
                <tr>
                    <th>Spam Filter</th>
                    <td>
                        <c:out value='${email.spamFilter ? "Yes" : "No"}'/>
                    </td>
                </tr>
                <tr>
                    <th>Signature</th>
                    <td>
                        <p>${email.signature}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="/"><button class="btn btn-info">Back</button></a>
                    </td>
                    <td>
                        <form action="/show-edit" method="get">
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
