<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 08:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Discount</title>
</head>
<body>
<form action="/discount" method="post">
    <label for="">Product Description</label>
    <input type="text" name="desc" placeholder="description"><br>
    <label for="">List Price</label>
    <input type="text" name="price" placeholder="0"><br>
    <label for="">Discount Percent</label>
    <input type="text" name="percent" placeholder="0%"><br>
    <button type="submit" name="submit">Calculator Discount</button>
</form>
</body>
</html>
