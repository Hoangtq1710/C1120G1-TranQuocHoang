<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
    <div class="container">
        <h2>Student List</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Point</th>
                    <th>Image</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td scope="row">${student.id}</td>
                    <td>${student.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${student.gender == 0}">Female</c:when>
                            <c:when test="${student.gender == 1}">Male</c:when>
                            <c:otherwise>LGBT</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${student.point}</td>
                    <td>
                        <img src="../img/${student.image}" width="50" height="50">
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>
