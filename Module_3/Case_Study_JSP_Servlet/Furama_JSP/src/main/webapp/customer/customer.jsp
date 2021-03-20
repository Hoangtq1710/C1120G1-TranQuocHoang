<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/cus_navbar.jsp" %>
<%--<%@include file="../page/left_content.jsp" %>--%>

<!-------------------body--------------------------------------------------------------->

<div class="col-sm-12">
    <div class="container-fluid">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#createCustomer" style="margin: 20px 0" >
            <i class="far fa-plus-square"></i>
        </button>

        <div class="modal fade" id="createCustomer">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create Customer</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <table class="table table-hover">
                                <thead>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>ID</th>
                                        <td>
                                            <input type="text" name="customerId" placeholder="KH-XXXX">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Customer Type</th>
                                        <td>
                                            <input type="text" name="customerTypeName" placeholder="Diamond">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Name</th>
                                        <td>
                                            <input type="text" name="customerName">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Gender</th>
                                        <td>
                                            <input type="text" name="customerGender" placeholder="Male">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Birthday</th>
                                        <td>
                                            <input type="date" name="customerBirthday">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>ID Card</th>
                                        <td>
                                            <input type="number" name="customerIdCard" placeholder="9 digit X or 12 digit X">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Phone</th>
                                        <td>
                                            <input type="text" name="customerPhone" placeholder="090/091/(+84) 090/(+84) 091">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Email</th>
                                        <td>
                                            <input type="email" name="customerEmail" placeholder="example@gmail.com">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Address</th>
                                        <td>
                                            <input type="text" name="customerAddress">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success" name="action" value="submitData">Create</button>
                            <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <div class="modal fade" id="deleteCustomer">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">ARE YOU SURE?</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-danger" onclick="submitFormDelete()">Delete</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

        <table class="table table-hover">
            <c:if test='${requestScope["listCustomer"] != null}'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name
<%--                        <a href="/customer?action=sort&sortBy=${"asc"}">--%>
<%--                            <i class="fas fa-sort-alpha-down"></i>--%>
<%--                        </a>--%>
<%--                        <a href="/customer?action=sort&sortBy=${"desc"}">--%>
<%--                            <i class="fas fa-sort-alpha-up"></i>--%>
<%--                        </a>--%>
                    </th>
                    <th>Customer Type</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCustomer}" var="customer">
                    <tr>
                        <td>${customer.getCustomerId()}</td>
                        <td>
                            <a href="/customer?action=view&id=${customer.getCustomerId()}">${customer.getCustomerName()}</a>
                        </td>
                        <td>${customer.getCustomerType().getCustomerTypeName()}</td>
                        <td>${customer.getCustomerBirthday()}</td>
                        <td>
                            <c:out value="${customer.isCustomerGender() ? 'Male' : 'Female'} "></c:out>
                        </td>
                        <td>${customer.getCustomerIdCard()}</td>
                        <td>${customer.getCustomerPhone()}</td>
                        <td>${customer.getCustomerEmail()}</td>
                        <td>${customer.getCustomerAddress()}</td>
                        <td>
                            <a type="button" class="btn btn-warning" href="/customer?action=edit&id=${customer.getCustomerId()}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteCustomer"
                                    onclick="saveIdDelete('${customer.getCustomerId()}')" >
                                <i class="fas fa-trash-alt"></i>
                            </button>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </c:if>
        </table>

        <a type="button" class="btn btn-info" href="/" style="margin-bottom: 15px">Back</a>
    </div>
</div>
</div>
</div>
<form action="/customer" method="post" id="formDelete">
    <input type="hidden" name="idCustomer" id="idDeleteCustomer">
    <input type="hidden" name="action" value="delete">
</form>
<script>

    function saveIdDelete(idCustomer) {
        document.getElementById("idDeleteCustomer").value = idCustomer;
    }

    function submitFormDelete() {
        document.getElementById("formDelete").submit();
    }

</script>
<%@include file="../page/footer.jsp" %>
