<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
</head>
<body>
    <div class="container">
        <h2>Customer List</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Tên</th>
                    <th>Ngày sinh</th>
                    <th>Địa chỉ</th>
                    <th>Ảnh</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customerList}" var="customer">
                    <tr>
                        <td scope="row">${customer.ten}</td>
                        <td>${customer.ngaysinh}</td>
                        <td>${customer.diachi}</td>
                        <td>
                            <img src="../img/${customer.image}" width="50" height="50">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
