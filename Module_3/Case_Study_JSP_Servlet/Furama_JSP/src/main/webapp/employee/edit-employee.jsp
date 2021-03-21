<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 21-Mar-21
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>

<%@include file="../page/navbar/emp_navbar.jsp" %>

<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid" style="margin-top: 15px">
        <form method="post">
            <h4>Edit Employee Information</h4>
            <table class="table table-hover">
                <tr hidden>
                    <th>ID</th>
                    <td>
                        <input type="text" name="employeeId" value="${requestScope["employee"].getEmployeeId()}">
                    </td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td>
                        <input type="text" name="employeeName" value="${requestScope["employee"].getEmployeeName()}">
                    </td>
                </tr>
                <tr>
                    <th>Position</th>
                    <td>
                        <select name="position">
                            <option value="1"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 1}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Receptionist
                            </option>
                            <option value="2"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 2}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Serve
                            </option>
                            <option value="3"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 3}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Expert
                            </option>
                            <option value="4"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 4}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Supervision
                            </option>
                            <option value="5"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 5}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Manager
                            </option>
                            <option value="6"
                                    <c:if test='${requestScope["employee"].getPosition().getPositionId()== 6}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Director
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Division</th>
                    <td>
                        <select name="division">
                            <option value="1"
                                    <c:if test='${requestScope["employee"].getDivision().getDivisionId()== 1}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Sale-Marketing
                            </option>
                            <option value="2"
                                    <c:if test='${requestScope["employee"].getDivision().getDivisionId()== 2}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Administration
                            </option>
                            <option value="3"
                                    <c:if test='${requestScope["employee"].getDivision().getDivisionId()== 3}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Serve
                            </option>
                            <option value="4"
                                    <c:if test='${requestScope["employee"].getDivision().getDivisionId()== 4}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Manager
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Education Degree</th>
                    <td>
                        <select name="eduDegree">
                            <option value="1"
                                    <c:if test='${requestScope["employee"].getEduDegree().getEduDegreeId()== 1}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Intermediate
                            </option>
                            <option value="2"
                                    <c:if test='${requestScope["employee"].getEduDegree().getEduDegreeId()== 2}'>
                                        selected="selected"
                                    </c:if>
                            >
                                College
                            </option>
                            <option value="3"
                                    <c:if test='${requestScope["employee"].getEduDegree().getEduDegreeId()== 3}'>
                                        selected="selected"
                                    </c:if>
                            >
                                University
                            </option>
                            <option value="4"
                                    <c:if test='${requestScope["employee"].getEduDegree().getEduDegreeId()== 4}'>
                                        selected="selected"
                                    </c:if>
                            >
                                Postgraduate
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Birthday</th>
                    <td>
                        <input type="date" name="birthday" value="${requestScope["employee"].getEmployeeBirthday()}">
                    </td>
                </tr>
                <tr>
                    <th>ID Card</th>
                    <td>
                        <input type="text" name="idCard" value="${requestScope["employee"].getEmployeeIdCard()}">
                    </td>
                </tr>
                <tr>
                    <th>Salary</th>
                    <td>
                        <input type="number" name="salary" value="${requestScope["employee"].getEmployeeSalary()}">
                    </td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>
                        <input type="tel" name="phone" value="${requestScope["employee"].getEmployeePhone()}">
                    </td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>
                        <input type="email" name="email" value="${requestScope["employee"].getEmployeeEmail()}">
                    </td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>
                        <input type="text" name="address" value="${requestScope["employee"].getEmployeeAddress()}">
                    </td>
                </tr>
                <tr hidden>
                    <th>Username</th>
                    <td>
                        <input type="text" name="username" value="${requestScope["employee"].getUser().getUsername()}">
                    </td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td>
                        <input type="text" name="password" value="${requestScope["employee"].getUser().getPassword()}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <a type="button" class="btn btn-info" href="employee">Back</a>
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
