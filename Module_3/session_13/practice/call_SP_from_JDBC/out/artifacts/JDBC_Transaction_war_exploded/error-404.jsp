<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 15-Mar-21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>404 Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0,
 	    maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <style>
        body {
            font-family: "Courier New", sans-serif;
        }
        .oops {
            font-size: 50px;
            color: teal;
        }
    </style>

</head>
<body>
<div class="container" style="text-align: center">
    <p class="oops">Oops!</p><br>
    <h2>We can't seem to find the page you're looking for.</h2>
    <button class="btn btn-light"><a style="text-decoration: none" href="/users">Back to User List</a></button>
    <h5>Error Code: 404</h5>
</div>
</body>
</html>

