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
    <title>Translate</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div style="text-align: center;width: 30%;margin: auto">
    <h1>Translate</h1>
    <form action="/translate" method="post">
        <table class="table table-hover">
            <thead></thead>
            <tbody>
                <tr>
                    <th>
                        <label for="input">ENTER</label>
                    </th>
                    <th>
                        <input type="text" name="input" id="input" value="${input}">
                    </th>
                    <th>
                        <button type="submit" class="btn btn-success">Translate</button>
                    </th>
                </tr>
                <tr>
                    <c:if test='${message == ""}'>
                        <th>
                            <label for="result">RESULT</label>
                        </th>
                        <th>
                            <input type="text" id="result" value="${result}" disabled>
                        </th>
                        <th>
                            <a href="/"><button type="button" class="btn btn-info">Back</button></a>
                        </th>
                    </c:if>
                    <c:if test='${message != "" and listKey != null}'>
                        <td colspan="3">
                            <h4 style="color: red">${message}</h4><br>
                            <p><h5>Tip</h5> :
                                <span style="color: cadetblue">
                                    <c:forEach items="${listKey}" var="key">
                                        ${key},
                                    </c:forEach>
                                </span>
                            </p>
                        </td>
                    </c:if>
                </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
