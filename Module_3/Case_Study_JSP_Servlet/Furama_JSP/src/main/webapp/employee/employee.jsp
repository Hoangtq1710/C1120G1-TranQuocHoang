<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/emp_navbar.jsp" %>
<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid">
        <button type="button" class="btn btn-success"  data-toggle="modal" title="Create Employee" data-target="#createEmployee" style="margin: 20px 20px" >
            <i class="far fa-plus-square"></i>
        </button>
        <a href="employee" type="button" class="btn btn-info" title="Refresh" style="float: right;margin: 20px 20px"><i class="fas fa-sync-alt"></i></a>

        <div class="modal fade" id="createEmployee">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create Employee</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <table class="table table-hover">
                                <thead>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>Name</th>
                                    <td>
                                        <input type="text" name="employeeName">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Position</th>
                                    <td>
                                        <select name="position">
                                            <option value="1">Receptionist</option>
                                            <option value="2">Serve</option>
                                            <option value="3">Expert</option>
                                            <option value="4">Supervision</option>
                                            <option value="5">Manager</option>
                                            <option value="6">Director</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Division</th>
                                    <td>
                                        <select name="division">
                                            <option value="1">Sale-Marketing</option>
                                            <option value="2">Administration</option>
                                            <option value="3">Serve</option>
                                            <option value="4">Manager</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Education Degree</th>
                                    <td>
                                        <select name="eduDegree">
                                            <option value="1">Intermediate</option>
                                            <option value="2">College</option>
                                            <option value="3">University</option>
                                            <option value="4">Postgraduate</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Birthday</th>
                                    <td>
                                        <input type="date" name="birthday">
                                    </td>
                                </tr>
                                <tr>
                                    <th>ID Card</th>
                                    <td>
                                        <input type="text" name="idCard" placeholder="9 or 12 digits of X">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Salary</th>
                                    <td>
                                        <input type="number" name="salary" placeholder="0 $">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Phone</th>
                                    <td>
                                        <input type="tel" name="phone" placeholder="090/091/(+84)">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Email</th>
                                    <td>
                                        <input type="email" name="email" placeholder="example@gmail.com">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Address</th>
                                    <td>
                                        <input type="text" name="address">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Username</th>
                                    <td>
                                        <input type="text" name="username">
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

        <table class="table table-hover">
            <c:if test='${requestScope["listEmployee"] != null}'>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Division</th>
                    <th>Degree</th>
                    <th>Birthday</th>
                    <th hidden>ID Card</th>
                    <th>Salary</th>
                    <th>Phone</th>
                    <th hidden>Email</th>
                    <th>Address</th>
                    <th hidden>UserName</th>
                    <th hidden>Password</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listEmployee}" var="employee">
                    <tr>
                        <td>${employee.getEmployeeId()}</td>
                        <td><a style="text-decoration: none" title="Click to detail" href="employee?action=view&id=${employee.getEmployeeId()}">${employee.getEmployeeName()}</a></td>
                        <td>${employee.getPosition().getPositionName()}</td>
                        <td>${employee.getDivision().getDivisionName()}</td>
                        <td>${employee.getEduDegree().getEduDegreeName()}</td>
                        <td>${employee.getEmployeeBirthday()}</td>
                        <td hidden>${employee.getEmployeeIdCard()}</td>
                        <td>${employee.getEmployeeSalary()}</td>
                        <td>${employee.getEmployeePhone()}</td>
                        <td hidden>${employee.getEmployeeEmail()}</td>
                        <td>${employee.getEmployeeAddress()}</td>
                        <td hidden>${employee.getUser().getUsername()}</td>
                        <td hidden>${requestScope["password"]}</td>
                        <td>
                            <a type="button" class="btn btn-warning" title="Edit" href="/employee?action=edit&id=${employee.getEmployeeId()}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" title="Delete" data-target="#deleteEmployee"
                                    onclick="saveIdDelete('${employee.getEmployeeId()}')" >
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
