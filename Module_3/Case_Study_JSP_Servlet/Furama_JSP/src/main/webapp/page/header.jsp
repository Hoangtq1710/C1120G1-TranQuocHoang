<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 11:45
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
    <link rel="stylesheet" href="../assert/style/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../assert/style/fontawesome/css/all.min.css" type="text/css">
</head>
<style>
    /* Make the image fully responsive */
    .carousel-inner img {
        width: 100%;
        height: 100%;
    }
</style>
<body>
<!-------------------header-------------------------------------------------------------------->
<div class="jumbotron text-center" style="margin-bottom: 0">
    <a href="/"><img src="../assert/img/logo.png" alt="logo" style="float: left"></a>


<%@include file="login.jsp" %>