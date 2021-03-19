<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 17-Mar-21
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Furama Management</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="style/fontawesome/css/all.min.css" type="text/css">
    <style>
        .fit-img {
            max-width: 100%;
            max-height: 100%;
            display: block;
        }
    </style>
</head>
<body>
<!-------------------header-------------------------------------------------------------------->
<div class="jumbotron text-center" style="margin-bottom:0; padding-top: 15px">
    <a href="index.jsp"><img src="img/logo.png" alt="logo" style="float: left"></a>
    <h1>Furama</h1>
    <h3 style="display: inline; float: right">Tran Quoc Hoang</h3>
</div>

<%@include file="page/navbar/home_navbar.jsp" %>
<%@include file="page/left_content.jsp" %>



<%@include file="page/main.jsp" %>





<%@include file="page/footer.jsp" %>
