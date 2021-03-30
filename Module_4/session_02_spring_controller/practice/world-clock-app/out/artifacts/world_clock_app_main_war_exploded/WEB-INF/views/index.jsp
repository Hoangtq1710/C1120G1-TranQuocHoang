<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 29-Mar-21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>World Clock</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container" style="margin-top: 20px; text-align: center">
        <h2 style="color:teal;">WORLD CLOCK</h2>
        <form action="/worldClock" method="get">
            <table class="table table-hover">
                <thead></thead>
                <tbody>
                <tr>
                    <th style="width: 40%"><label for="city">SELECT CITY</label></th>
                    <td>
                        <select name="city" id="city">
                            <option value="Asia/Ho_Chi_Minh" disabled>----Select a city----</option>
                            <option value="Asia/Ho_Chi_Minh" <c:if test='${city == "Asia/Ho_Chi_Minh"}'>selected="selected"</c:if>>Ho Chi Minh</option>
                            <option value="Singapore" <c:if test='${city == "Singapore"}'>selected="selected"</c:if>>Singapore</option>
                            <option value="Asia/Hong_Kong" <c:if test='${city == "Asia/Hong_Kong"}'>selected="selected"</c:if>>Hong Kong</option>
                            <option value="Asia/Tokyo" <c:if test='${city == "Asia/Tokyo"}'>selected="selected"</c:if>>Tokyo</option>
                            <option value="Asia/Seoul" <c:if test='${city == "Asia/Seoul"}'>selected="selected"</c:if>>Seoul</option>
                            <option value="Europe/London" <c:if test='${city == "Europe/London"}'>selected="selected"</c:if>>London</option>
                            <option value="Europe/Madrid" <c:if test='${city == "Europe/Madrid"}'>selected="selected"</c:if>>Madrid</option>
                            <option value="America/New_York" <c:if test='${city == "America/New_York"}'>selected="selected"</c:if>>New York</option>
                            <option value="Australia/Sydney" <c:if test='${city == "Australia/Sydney"}'>selected="selected"</c:if>>Sydney</option>
                            <option value="Argentina/Buenos_Aires" <c:if test='${city == "Argentina/Buenos_Aires"}'>selected="selected"</c:if>>Buenos Aires</option>
                        </select>
                    </td>
                    <td><button class="btn btn-success btn-sm" type="submit">DISPLAY</button></td>
                </tr>
                <c:if test='${not empty date}'>
                    <tr>
                        <th>Current Time in ${city}</th>
                        <th><span style="color: darkorange; font-size: 18px">${date}</span></th>
                        <th></th>
                    </tr>
                </c:if>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>
