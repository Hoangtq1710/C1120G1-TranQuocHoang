<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Convert</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="text-align: center">
    <form action="/convert" method="get">
        <h1 style="color: chocolate">Currency Converter</h1>
        <label for="from">FROM</label>
        <select name="from" id="from">
            <option value="usd" <c:if test="${from == 'usd'}">selected="selected"</c:if> >USD</option>
            <option value="eur" <c:if test="${from == 'eur'}">selected="selected"</c:if> >EUR</option>
            <option value="vnd" <c:if test="${from == 'vnd'}">selected="selected"</c:if> >VND</option>
            <option value="cad" <c:if test="${from == 'cad'}">selected="selected"</c:if> >CAD</option>
            <option value="gbp" <c:if test="${from == 'gbp'}">selected="selected"</c:if> >GBP</option>
        </select>
        <input type="number" name="currency" value="${currency}">
        <label for="to">TO</label>
        <select name="to" id="to">
            <option value="usd" <c:if test="${to == 'usd'}">selected="selected"</c:if> >USD</option>
            <option value="eur" <c:if test="${to == 'eur'}">selected="selected"</c:if> >EUR</option>
            <option value="vnd" <c:if test="${to == 'vnd'}">selected="selected"</c:if> >VND</option>
            <option value="cad" <c:if test="${to == 'cad'}">selected="selected"</c:if> >CAD</option>
            <option value="gbp" <c:if test="${to == 'gbp'}">selected="selected"</c:if> >GBP</option>
        </select>
        <input type="number" value="${result}" disabled>
        <button class="btn btn-info btn-sm" type="submit">Convert</button>
    </form>
</div>
</body>
</html>
