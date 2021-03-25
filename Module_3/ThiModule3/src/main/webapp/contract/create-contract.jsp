<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25-Mar-21
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/cus_navbar.jsp" %>
<%@include file="../page/left_content.jsp" %>
<div class="container">

    <form action="/contract" method="post">
        <h1>Create Product</h1>
        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <td>
                    <input type="text" name="productName" required>
                </td>
            </tr>
            <tr>
                <th>Price</th>
                <td>
                    <input type="number" name="price" required>
                </td>
            </tr>
            <tr>
                <th>Percent</th>
                <td>
                    <input type="number" name="percent" required>
                </td>
            </tr>
            <tr>
                <th>Stock</th>
                <td>
                    <input type="number" name="stock" required>
                </td>
            </tr>


        </table>
        <button type="submit" name="action" value="create">Create</button>
    </form>

</div>

</body>
</html>
