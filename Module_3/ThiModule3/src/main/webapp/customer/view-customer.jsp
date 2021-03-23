<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>

<%@include file="../page/navbar/cus_navbar.jsp" %>

<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid" style="margin-top: 15px">
        <h4>View Customer Information</h4>
        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <td>${requestScope["customer"].getCustomerId()}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${requestScope["customer"].getCustomerName()}</td>
            </tr>
            <tr>
                <th>Customer Type</th>
                <td>${requestScope["customer"].getCustomerType().getCustomerTypeName()}</td>
            </tr>
            <tr>
                <th>Birthday</th>
                <td>${requestScope["customer"].getCustomerBirthday()}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>
                    <c:out value="${customer.isCustomerGender() ? 'Male' : 'Female'} "></c:out>
                </td>
            </tr>
            <tr>
                <th>ID Card</th>
                <td>${requestScope["customer"].getCustomerIdCard()}</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${requestScope["customer"].getCustomerPhone()}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${requestScope["customer"].getCustomerEmail()}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${requestScope["customer"].getCustomerAddress()}</td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <a type="button" class="btn btn-info" href="customer">Back</a>
                </td>
            </tr>
        </table>
    </div>

</div>
</div>
</div>

<%@include file="../page/footer.jsp" %>
