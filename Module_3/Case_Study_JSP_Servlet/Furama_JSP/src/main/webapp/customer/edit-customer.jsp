<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 19-Mar-21
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>

<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #046056; width: 100%">
    <a class="navbar-brand" href="../index.jsp"><i class="fas fa-home"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-------------------navbar----------------------------------------------------------------->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link " href="../employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="../contract">Contract</a>
            </li>
            <!--            them Search-->
        </ul>
    </div>

    <!-------------------search----------------------------------------------------------------->
    <div>
        <form method="get" style="float: right" class="input-group">
            <input type="text" name="country" id="search" class="form-control" placeholder="Search ...">

            <div class="input-group-append" style="padding-left: 5px">
                <button type="submit" class="btn btn-outline-light">
                    <i class="fas fa-search"></i>
                </button>
                <input name="action" value="search" hidden>
            </div>
        </form>
    </div>
</nav>

<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-10">
    <div class="container-fluid">
        <form method="post">
            <h4>Edit Customer Information</h4>
            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="customerName" value="${requestScope["customer"].getCustomerName()}">
                    </td>
                </tr>
                <tr>
                    <th>Customer Type</th>
                    <td>
                        <input type="text" name="customerTypeName" value="${requestScope["customer"].getCustomerType().getCustomerTypeName()}">
                    </td>
                </tr>
                <tr>
                    <th>Birthday</th>
                    <td>
                        <input type="date" name="customerBirthday" value="${requestScope["customer"].getCustomerBirthday()}">
                    </td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>
                        <input type="text" name="customerGender"
                               value="<c:out value="${customer.isCustomerGender() ? 'Male' : 'Female'} "></c:out>">
                    </td>
                </tr>
                <tr>
                    <th>ID Card</th>
                    <td>
                        <input type="number" name="customerIdCard" value="${requestScope["customer"].getCustomerIdCard()}">
                    </td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>
                        <input type="text" name="customerPhone" value="${requestScope["customer"].getCustomerPhone()}">
                    </td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>
                        <input type="email" name="customerEmail" value="${requestScope["customer"].getCustomerEmail()}">
                    </td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>
                        <input type="text" name="customerAddress" value="${requestScope["customer"].getCustomerAddress()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn-warning" name="action" value="edit">Update</button>
                    </td>
                    <td>
                        <a type="button" class="btn btn-info" href="customer">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</div>
</div>
</div>

<%@include file="../page/footer.jsp" %>

