<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10-Mar-21
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Converter</title>
    <style>
      #submit {
        margin-top: 10px;
        background-color: teal;
        color: white;
      }
    </style>
  </head>
  <body>
    <h1>Currency Converter</h1>
    <form action="/convert" method="post">
      <label for="">Rate :</label><br>
      <input type="text" name="rate" placeholder="rate" value="22000"><br>
      <label for="">USD :</label><br>
      <input type="text" name="usd" placeholder="USD" value="0"><br>
      <input type="submit" id="submit" value="Converter">
    </form>
  </body>
</html>
