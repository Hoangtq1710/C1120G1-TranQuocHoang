<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12-Mar-21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style></style>
</head>
<body>
    <h2>Basic Calculator</h2>
    <fieldset>
        <legend>Calculator</legend>
        <form action="/calculator" method="post">
            <table>
                <tr>
                    <td><label>First Operator:</label></td>
                    <td><input type="text" placeholder="0" name="first"></td>
                </tr>
                <tr>
                    <td><label>Operator:</label></td>
                    <td>
                        <select name="operator">
                            <option value="+">Addition</option>
                            <option value="-">Subtraction</option>
                            <option value="*">Multiplication</option>
                            <option value="/">Division</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Second Operator:</td>
                    <td><input type="text" placeholder="0" name="second"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Calculator"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
