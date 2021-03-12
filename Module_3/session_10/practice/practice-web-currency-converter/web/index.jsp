<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Converter Currency</title>
  </head>
  <body>
  <h1>Currency Converter</h1>
  <form action="converter.jsp" method="post">
    <label>Rate: </label><br>
    <input type="text" name="rate" placeholder="rate" value="22000"><br>
    <label>USD: </label><br>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <button id="submit" type="submit">Convert</button>
  </form>

  </body>
</html>
