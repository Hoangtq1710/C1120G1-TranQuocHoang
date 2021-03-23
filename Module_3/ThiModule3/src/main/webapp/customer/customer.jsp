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
<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->

<div class="col-sm-12">
    <div class="container-fluid">
        <button type="button" class="btn btn-success" data-toggle="modal" title="Create Customer" data-target="#createCustomer" style="margin: 20px 20px" >
            <i class="far fa-plus-square"></i>
        </button>
        <a href="customer" type="button" class="btn btn-info" title="Refresh" style="float: right;margin: 20px 20px"><i class="fas fa-sync-alt"></i></a>

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
                            <table class="table table-striped">
                                <thead>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>ID</th>
                                        <td>
                                            <input type="text" name="customerId" placeholder="KH-XXXX">
                                            <c:if test='${messageId!= null}'>
                                                <span style="color: red" class="message">${messageId}</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Customer Type</th>
                                        <td>
                                            <select name="customerTypeName" required>
                                                <option value="1">Diamond</option>
                                                <option value="2">Platinum</option>
                                                <option value="3">Gold</option>
                                                <option value="4">Silver</option>
                                                <option value="5">Member</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Name</th>
                                        <td>
                                            <input type="text" name="customerName" required>
                                            <c:if test='${messageName!= null}'>
                                                <span style="color: red" class="message">${messageName}</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Gender</th>
                                        <td>
                                            <select name="customerGender" required>
                                                <option value="Male">Male</option>
                                                <option value="Female">Female</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Birthday</th>
                                        <td>
                                            <input type="date" name="customerBirthday" required>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>ID Card</th>
                                        <td>
                                            <input type="number" required name="customerIdCard" placeholder="9 or 12 digits of X">
                                            <c:if test='${messageIdCard!= null}'>
                                                <span style="color: red" class="message">${messageIdCard}</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Phone</th>
                                        <td>
                                            <input type="tel" name="customerPhone" placeholder="090/091/(+84)">
                                            <c:if test='${messagePhone!= null}'>
                                                <span style="color: red" class="message">${messagePhone}</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Email</th>
                                        <td>
                                            <input type="email" name="customerEmail" placeholder="example@gmail.com">
                                            <c:if test='${messageEmail!= null}'>
                                                <span style="color: red" class="message">${messageEmail}</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Address</th>
                                        <td>
                                            <input type="text" name="customerAddress" required>
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
                    <div class="modal-body">
                        <input type="text" id="modelId" size="50" disabled style="border: none; background: white; width: 100%">
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-danger" onclick="submitFormDelete()">Delete</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>

        <table id="customer" class="table table-striped">
            <c:if test='${requestScope["listCustomer"] != null}'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Birthday</th>
                    <th>Gender</th>
                    <th>Id Card</th>
                    <th>Phone</th>
                    <th hidden>Email</th>
                    <th>Address</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCustomer}" var="customer">
                    <tr>
                        <td>${customer.getCustomerId()}</td>
                        <td>${customer.getCustomerName()}</td>
                        <td>${customer.getCustomerType().getCustomerTypeName()}</td>
                        <td>${customer.getCustomerBirthday()}</td>
                        <td>
                            <c:out value="${customer.isCustomerGender() ? 'Male' : 'Female'} "></c:out>
                        </td>
                        <td>${customer.getCustomerIdCard()}</td>
                        <td>${customer.getCustomerPhone()}</td>
                        <td hidden>${customer.getCustomerEmail()}</td>
                        <td>${customer.getCustomerAddress()}</td>
                        <td>
                            <a type="button" class="btn btn-info" title="View" href="/customer?action=view&id=${customer.getCustomerId()}">
                                <i class="far fa-eye"></i>
                            </a>
                            <a type="button" class="btn btn-warning" title="Edit" href="/customer?action=edit&id=${customer.getCustomerId()}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <button type="button" class="btn btn-danger" title="Delete" data-toggle="modal" data-target="#deleteCustomer"
                                    onclick="saveIdDelete('${customer.getCustomerId()}', '${customer.getCustomerName()}')" >
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
    <input type="hidden" name="id" value="delete">
</form>


<%@include file="../page/footer.jsp" %>
