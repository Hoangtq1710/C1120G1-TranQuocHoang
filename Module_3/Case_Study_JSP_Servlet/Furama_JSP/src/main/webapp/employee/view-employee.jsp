<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 21-Mar-21
  Time: 09:23
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
        <h4>View Employee Information</h4>
        <table class="table table-hover">
            <tr>
                <th>Name</th>
                <td>${requestScope["employee"].getEmployeeName()}</td>
            </tr>
            <tr>
                <th>Position</th>
                <td>${requestScope["employee"].getPosition().getPositionName()}</td>
            </tr>
            <tr>
                <th>Division</th>
                <td>${requestScope["employee"].getDivision().getDivisionName()}</td>
            </tr>
            <tr>
                <th>Education Degree</th>
                <td>${requestScope["employee"].getEduDegree().getEduDegreeName()}</td>
            </tr>
            <tr>
                <th>Birthday</th>
                <td>
                    ${requestScope["employee"].getEmployeeBirthday()}
                </td>
            </tr>
            <tr>
                <th>ID Card</th>
                <td>${requestScope["employee"].getEmployeeIdCard()}</td>
            </tr>
            <tr>
                <th>Salary</th>
                <td>${requestScope["employee"].getEmployeeSalary()} $</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${requestScope["employee"].getEmployeePhone()}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${requestScope["employee"].getEmployeeEmail()}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${requestScope["employee"].getEmployeeAddress()}</td>
            </tr>
            <tr hidden>
                <th>Username</th>
                <td>${requestScope["employee"].getUser().getUsername()}</td>
            </tr>
            <tr hidden>
                <th>Password</th>
                <td>${requestScope["employee"].getUser().getPassword()}</td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <a type="button" class="btn btn-info" href="employee">Back</a>
                </td>
            </tr>
        </table>
    </div>

</div>
</div>
</div>

<%@include file="../page/footer.jsp" %>
