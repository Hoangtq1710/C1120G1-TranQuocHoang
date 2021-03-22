<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 20-Mar-21
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>

<%@include file="../page/navbar/ser_navbar.jsp" %>

<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid" style="margin-top: 15px">
        <h4>View Service Information</h4>
        <table class="table table-hover">
            <tr>
                <th>ID</th>
                <td>${requestScope["service"].getServiceId()}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${requestScope["service"].getServiceName()}</td>
            </tr>
            <tr>
                <th>Rent Type</th>
                <td>${requestScope["service"].getRentType().getRentTypeName()}</td>
            </tr>
            <tr>
                <th>Service Type</th>
                <td>${requestScope["service"].getServiceType().getServiceTypeName()}</td>
            </tr>
            <tr>
                <th>Area</th>
                <td>${requestScope["service"].getServiceArea()} m<sup>2</sup></td>
            </tr>
            <tr>
                <th>Max People</th>
                <td>${requestScope["service"].getServiceMaxPeople()}</td>
            </tr>
            <tr>
                <th>Cost</th>
                <td>${requestScope["service"].getServiceCost()} $</td>
            </tr>
            <c:if test='${requestScope["service"].getStandardRoom() != ""}'>
                <tr>
                    <th>Standard Room</th>
                    <td>${requestScope["service"].getStandardRoom()}</td>
                </tr>
            </c:if>
            <c:if test='${requestScope["service"].getNumberOfFloor() != 0}'>
                <tr>
                    <th>No Floor</th>
                    <td>${requestScope["service"].getNumberOfFloor()}</td>
                </tr>
            </c:if>
            <c:if test='${requestScope["service"].getPoolArea() != 0}'>
                <tr>
                    <th>Pool Area</th>
                    <td>${requestScope["service"].getPoolArea()} m<sup>2</sup></td>
                </tr>
            </c:if>
            <c:if test='${requestScope["service"].getDescription() != ""}'>
                <tr>
                    <th>Description</th>
                    <td>${requestScope["service"].getDescription()}</td>
                </tr>
            </c:if>
            <tr>
                <th></th>
                <td>
                    <a type="button" class="btn btn-info" href="service">Back</a>
                </td>
            </tr>
        </table>
    </div>

</div>
</div>
</div>

<%@include file="../page/footer.jsp" %>
