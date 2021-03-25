
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 25-Mar-21
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/cus_navbar.jsp" %>
<%@include file="../page/left_content.jsp" %>
<div class="container">
    <h1>LIST PRODUCT</h1>
    <a href="contract?action=create">Create</a>
    <div>
        <div>
            <form action="/contract" method="post">
                <p>Danh sach top</p>
                <select name="number">
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
                <p>San pham nhieu nhat</p>
                <button type="submit" name="action" value="topview">XEM</button>
            </form>

        </div>
    </div>

    <div>
        <form action="/contract" method="post">
            <p>Danh sach san pham tu </p>
            <input type="date" name="start" required value="${start}">
            <p> den </p>
            <input type="date" name="end" required value="${end}">
            <button type="submit" name="action" value="distance">XEM</button>
        </form>
    </div>
    <table class="table table-hover">
        <thead>

        </thead>
        <tbody>
        <tr>
            <td>Product ID</td>
            <td>Product Name</td>
            <td>Price</td>
            <td>Percent</td>
            <td>Stock</td>
        </tr>
        <c:forEach items="${listProduct}" var="product">
            <tr>
                <td>${product.getProductId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getPercent()}</td>
                <td>${product.getStock()}</td>
            </tr>
        </c:forEach>
        </tbody>
        
    </table>
</div>
<%@include file="../page/footer.jsp" %>
