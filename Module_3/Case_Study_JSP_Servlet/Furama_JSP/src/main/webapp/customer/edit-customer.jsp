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

<%@include file="../page/navbar/cus_navbar.jsp" %>

<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid" style="margin-top: 15px">
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
                        <select name="customerTypeName">
                            <option value="Diamond">Diamond</option>
                            <option value="Platinum">Platinum</option>
                            <option value="Gold">Gold</option>
                            <option value="Silver">Silver</option>
                            <option value="Member">Member</option>
                        </select>
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
                        <select name="customerGender">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
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
                        <input type="tel" name="customerPhone" value="${requestScope["customer"].getCustomerPhone()}">
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
                        <a type="button" class="btn btn-info" href="customer">Back</a>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-warning" name="action" value="edit">Update</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

</div>
</div>
</div>

<%@include file="../page/footer.jsp" %>

