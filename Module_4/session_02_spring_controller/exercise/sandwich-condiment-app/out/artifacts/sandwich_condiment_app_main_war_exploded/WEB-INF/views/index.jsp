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
    <title>Sandwich</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Sandwich Condiments</h1>
    <table>
        <form action="/sandwich" method="get">
            <tr>
                <td>
                    <div class="form-check">
                        <label class="form-check-label" for="lettuce">
                            <input type="checkbox" class="form-check-input" id="lettuce" name="condiments" value="Lettuce">Lettuce
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-check">
                        <label class="form-check-label" for="tomato">
                            <input type="checkbox" class="form-check-input" id="tomato" name="condiments" value="Tomato">Tomato
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-check">
                        <label class="form-check-label" for="mustard">
                            <input type="checkbox" class="form-check-input" id="mustard" name="condiments" value="Mustard">Mustard
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-check">
                        <label class="form-check-label" for="sprouts">
                            <input type="checkbox" class="form-check-input" id="sprouts" name="condiments" value="Sprouts">Sprouts
                        </label>
                    </div>
                </td>
            </tr>
            <tr style="margin-top: 10px">
                <td>
                    <button type="submit" class="btn btn-primary">Save</button>
                </td>
            </tr>
        </form>
    </table>

</div>
</body>
</html>
