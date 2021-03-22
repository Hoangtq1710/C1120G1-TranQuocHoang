<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/con_navbar.jsp" %>
<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid">

        <button type="button" class="btn btn-success" data-toggle="modal" title="Create Contract" data-target="#createContract" style="margin: 20px 20px" >
            <i class="far fa-plus-square"></i>
        </button>
        <a href="contract" type="button" class="btn btn-info" title="Refresh" style="float: right;margin: 20px 20px"><i class="fas fa-sync-alt"></i></a>

        <div class="modal fade" id="createContract">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create Contract</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <table class="table table-striped">
                                <thead>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>Customer</th>
                                    <td>
                                        <select name="customerId" required>
                                            <c:forEach items='${requestScope["listCustomer"]}' var="customer">
                                                <option value="${customer.getCustomerId()}">${customer.getCustomerName()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Employee</th>
                                    <td>
                                        <select name="employeeId" required>
                                            <c:forEach items='${requestScope["listEmployee"]}' var="employee">
                                                <option value="${employee.getEmployeeId()}">${employee.getEmployeeName()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Service</th>
                                    <td>
                                        <select name="serviceId" required>
                                            <c:forEach items='${requestScope["listService"]}' var="service">
                                                <option value="${service.getServiceId()}">${service.getServiceName()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Start Date</th>
                                    <td>
                                        <input type="date" name="startDate" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>End Date</th>
                                    <td>
                                        <input type="date" name="endDate" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Deposit</th>
                                    <td>
                                        <input type="number" name="deposit" placeholder="0.0 $">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Total Money</th>
                                    <td>
                                        <input type="number" name="totalMoney" placeholder="0.0 $" required>
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

        <table class="table table-striped">
            <c:if test='${requestScope["listContract"] != null}'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Employee Name</th>
                    <th>Customer Name</th>
                    <th>Service Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Contract Deposit</th>
                    <th>Total Money</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items='${requestScope["listContract"]}' var="contract">
                    <tr>
                        <td>${contract.getContractId()}</td>
                        <td>${contract.getEmployee().getEmployeeName()}</td>
                        <td>${contract.getCustomer().getCustomerName()}</td>
                        <td>${contract.getService().getServiceName()}</td>
                        <td>${contract.getContractStartDate()}</td>
                        <td>${contract.getContractEndDate()}</td>
                        <td>${contract.getContractDeposit()}</td>
                        <td>${contract.getContractTotalMoney()}</td>
                        <td>
                            <a type="button" class="btn btn-warning" title="Edit" href="/contract?action=edit&id=${contract.getContractId()}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" title="Delete" data-target="#deleteContract"
                                    onclick="saveIdDelete('${contract.getContractId()}')" >
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

<%@include file="../page/footer.jsp" %>
