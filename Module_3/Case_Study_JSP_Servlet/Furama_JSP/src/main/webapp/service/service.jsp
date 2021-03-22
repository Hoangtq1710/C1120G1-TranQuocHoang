<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../page/header.jsp" %>
<%@include file="../page/navbar/ser_navbar.jsp" %>
<%@include file="../page/left_content.jsp" %>

<!-------------------body--------------------------------------------------------------->
<div class="col-sm-12">
    <div class="container-fluid">
        <button type="button" class="btn btn-success"  data-toggle="modal" title="Create Villa" data-target="#createVilla" style="margin: 20px 20px" >
            <i class="far fa-plus-square"></i>
        </button>
        <button type="button" class="btn btn-info" data-toggle="modal" title="Create House" data-target="#createHouse" style="margin: 20px 20px" >
            <i class="far fa-plus-square"></i>
        </button>
        <button type="button" class="btn btn-warning" data-toggle="modal" title="Create Room" data-target="#createRoom" style="margin: 20px 20px;" >
            <i class="far fa-plus-square"></i>
        </button>

        <a href="service" type="button" class="btn btn-info" title="Refresh" style="float: right;margin: 20px 20px"><i class="fas fa-sync-alt"></i></a>

        <div class="modal fade" id="createVilla">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create New Villa</h4>
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
                                        <input type="text" name="serviceId" placeholder="DV-XXXX">
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Service Type</th>
                                    <td>
                                        <input type="text" name="serviceType" value="1">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent Type</th>
                                    <td>
                                        <select name="rentType">
                                            <option value="1">Rent by Hour</option>
                                            <option value="2">Rent by Day</option>
                                            <option value="3">Rent by Month</option>
                                            <option value="4">Rent by Year</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area</th>
                                    <td>
                                        <input type="number" name="serviceArea" placeholder="15">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max People</th>
                                    <td>
                                        <input type="number" name="maxPeople" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost</th>
                                    <td>
                                        <input type="number" name="serviceCost" placeholder="0 $">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Standard Room</th>
                                    <td>
                                        <select name="standardRoom">
                                            <option value="VIP">VIP</option>
                                            <option value="Business">Business</option>
                                            <option value="Normal">Normal</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Pool Area</th>
                                    <td>
                                        <input type="number" name="poolArea" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Number of Floor</th>
                                    <td>
                                        <input type="number" name="numOfFloor" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Description</th>
                                    <td>
                                        <input type="text" name="description">
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

        <div class="modal fade" id="createHouse">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create New House</h4>
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
                                        <input type="text" name="serviceId" placeholder="DV-XXXX">
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Service Type</th>
                                    <td>
                                        <input type="text" name="serviceType" value="2">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent Type</th>
                                    <td>
                                        <select name="rentType">
                                            <option value="1">Rent by Hour</option>
                                            <option value="2">Rent by Day</option>
                                            <option value="3">Rent by Month</option>
                                            <option value="4">Rent by Year</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area</th>
                                    <td>
                                        <input type="number" name="serviceArea" placeholder="15">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max People</th>
                                    <td>
                                        <input type="number" name="maxPeople" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost</th>
                                    <td>
                                        <input type="number" name="serviceCost" placeholder="0 $">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Standard Room</th>
                                    <td>
                                        <select name="standardRoom">
                                            <option value="VIP">VIP</option>
                                            <option value="Business">Business</option>
                                            <option value="Normal">Normal</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Pool Area</th>
                                    <td>
                                        <input type="number" name="poolArea" hidden value="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Number of Floor</th>
                                    <td>
                                        <input type="number" name="numOfFloor" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Description</th>
                                    <td>
                                        <input type="text" name="description">
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

        <div class="modal fade" id="createRoom">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Create New Room</h4>
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
                                        <input type="text" name="serviceId" placeholder="DV-XXXX">
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Service Type</th>
                                    <td>
                                        <input type="text" name="serviceType" value="3">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Rent Type</th>
                                    <td>
                                        <select name="rentType">
                                            <option value="1">Rent by Hour</option>
                                            <option value="2">Rent by Day</option>
                                            <option value="3">Rent by Month</option>
                                            <option value="4">Rent by Year</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Area</th>
                                    <td>
                                        <input type="number" name="serviceArea" placeholder="15">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Max People</th>
                                    <td>
                                        <input type="number" name="maxPeople" placeholder="0">
                                    </td>
                                </tr>
                                <tr>
                                    <th>Cost</th>
                                    <td>
                                        <input type="number" name="serviceCost" placeholder="0 $">
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Standard Room</th>
                                    <td>
                                        <input type="text" name="standardRoom" value="" hidden>
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Pool Area</th>
                                    <td>
                                        <input type="number" name="poolArea" value="0" hidden>
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Number of Floor</th>
                                    <td>
                                        <input type="number" name="numOfFloor" value="0" hidden>
                                    </td>
                                </tr>
                                <tr hidden>
                                    <th>Description</th>
                                    <td>
                                        <input type="text" name="description" value="" hidden>
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
            <c:if test='${requestScope["listService"] != null}'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Rent Type</th>
                        <th>Service Type</th>
                        <th>Area</th>
                        <th>Standard Room</th>
                        <th>No Floors</th>
                        <th>Pool Area</th>
                        <th>Cost</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listService}" var="service">
                        <tr>
                            <td>${service.getServiceId()}</td>
                            <td><a style="text-decoration: none" title="Click to detail" href="service?action=view&id=${service.getServiceId()}">${service.getServiceName()}</a></td>
                            <td>${service.getRentType().getRentTypeName()}</td>
                            <td>${service.getServiceType().getServiceTypeName()}</td>
                            <td>${service.getServiceArea()}</td>
                            <td>${service.getStandardRoom()}</td>
                            <td>${service.getNumberOfFloor()}</td>
                            <td>${service.getPoolArea()}</td>
                            <td>${service.getServiceCost()}</td>
                            <td>
                                <a type="button" class="btn btn-warning" title="Edit" href="/service?action=edit&id=${service.getServiceId()}">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <button type="button" class="btn btn-danger" data-toggle="modal" title="Delete" data-target="#deleteService"
                                        onclick="saveIdDelete('${service.getServiceId()}')" >
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
