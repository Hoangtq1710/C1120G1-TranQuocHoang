<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 17-Mar-21
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Furama</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="assert/style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assert/style/fontawesome/css/all.min.css" type="text/css">

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
<div class="jumbotron text-center"  style="margin-bottom: 0">
    <a href="index.jsp"><img src="assert/img/logo.png" alt="logo" style="float: left"></a>

<%@include file="page/login.jsp" %>

<%@include file="page/navbar/home_navbar.jsp" %>
<%@include file="page/left_content.jsp" %>



<%@include file="page/main.jsp" %>





<%@include file="page/footer.jsp" %>
