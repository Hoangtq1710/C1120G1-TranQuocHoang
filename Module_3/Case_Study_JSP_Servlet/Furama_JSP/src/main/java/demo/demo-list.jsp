<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: TechCare--%>
<%--  Date: 3/17/2021--%>
<%--  Time: 2:48 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<link rel="stylesheet" href="../../bootstrap413/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body onload="myFunction('${message}')">--%>
<%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">--%>
<%--   ADD NEW CUSTOMER--%>
<%--</button>--%>
<%--<table id="customer" class="table table-striped">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">Customer id</th>--%>
<%--        <th scope="col">Customer name</th>--%>
<%--        <th scope="col">Birthday</th>--%>
<%--        <th scope="col">Gender</th>--%>
<%--        <th scope="col">Customer type</th>--%>
<%--        <th scope="col">Action</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="cus" items="${listCus}">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${cus.idCustomer}"/></td>--%>
<%--            <td><c:out value="${cus.nameCustomer}"/></td>--%>
<%--            <td><c:out value="${cus.birthday}"/></td>--%>
<%--            <td><c:out value="${cus.gender ? 'Nam':'Nữ'}"/></td>--%>
<%--            <td><c:out value="${cus.customerType.nameCustomerType}"/></td>--%>
<%--            <td><a class="btn btn-danger" href="#" onclick="customerSetId('${cus.idCustomer}','${cus.nameCustomer}')"--%>
<%--                   data-toggle="modal" data-target="#deleteModel">Delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--&lt;%&ndash; ----------------------------------------------------------------- &ndash;%&gt;--%>
<%--&lt;%&ndash; modal delete customer &ndash;%&gt;--%>
<%--<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"--%>
<%--     aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<form action="/customer" method="post" id="deleteCustomer">--%>
<%--    <input type="hidden" name="action" value="delete">--%>
<%--    <input type="hidden" name="idCustomer" id="idCustomer">--%>
<%--</form>--%>

<%--&lt;%&ndash; ----------------------------------------------------------------- &ndash;%&gt;--%>

<%--<!-- modal add new customer -->--%>



<%--<!-- ----------------------------------------------------------------------- -->--%>
<%--<!-- Button trigger modal -->--%>


<%--<!-- Modal -->--%>
<%--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabe">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form method="post" action="/customer?action=create" id="fomrAdd">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="exampleInputEmail1">Customer name</label>--%>
<%--                        <input type="text" name="customerName" class="form-control" id="exampleInputEmail1"--%>
<%--                               aria-describedby="emailHelp" value="<c:out value='${customer.nameCustomer}'/>">--%>
<%--                        <p>--%>
<%--                            <c:if test='${message!= null}'>--%>
<%--                                <span style="color: red" class="message">${message}</span>--%>
<%--                            </c:if>--%>
<%--                        </p>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="exampleInputPassword1">Birthday</label>--%>
<%--                        <input type="text" name="birthday" value="<c:out value='${customer.birthday}'/>"--%>
<%--                               class="form-control" id="exampleInputPassword1">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="gender">Gender</label>--%>
<%--                        <select name="gender" class="form-control" id="gender">--%>
<%--                            <option value="true" ${customer.gender == 'true' ? 'selected':''}>Nam</option>--%>
<%--                            <option value="false" ${customer.gender == 'false' ? 'selected':''}>Nữ</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="custype">Customer Type</label>--%>
<%--                        <select name="cusType" class="form-control" id="custype">--%>
<%--                            <c:forEach var="customerType" items="${customerTypeList}">--%>
<%--                                <c:choose>--%>
<%--                                    <c:when test="${customerType.idCustomerType.equals(customer.customerType.idCustomerType)}">--%>
<%--                                        <option value="<c:out value='${customerType.idCustomerType}'/>" selected><c:out--%>
<%--                                                value="${customerType.nameCustomerType}"></c:out></option>--%>
<%--                                    </c:when>--%>
<%--                                    <c:otherwise>--%>
<%--                                        <option value="<c:out value='${customerType.idCustomerType}'/>"><c:out--%>
<%--                                                value="${customerType.nameCustomerType}"></c:out></option>--%>
<%--                                    </c:otherwise>--%>
<%--                                </c:choose>--%>
<%--                            </c:forEach>--%>

<%--                        </select>--%>
<%--                    </div>--%>
<%--                    <button type="submit" class="btn btn-primary" id="submit_id">ADD</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="../../jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="../../bootstrap413/js/popper.min.js"></script>--%>
<%--<script src="../../datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>--%>
<%--<script src="../../bootstrap413/js/bootstrap.min.js"></script>--%>
<%--<script src="../../bootstrap413/js/bootstrap.bundle.js"></script>--%>
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('#customer').dataTable({--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 5--%>
<%--        })--%>
<%--    })--%>
<%--</script>--%>
<%--<script>--%>

<%--    function customerSetId(id, name) {--%>
<%--        document.getElementById("idCustomer").value = id;--%>
<%--        document.getElementById("modelId").value = "Do you want delete customer name: " + name;--%>
<%--    }--%>

<%--    function submitDelete() {--%>
<%--        document.getElementById("deleteCustomer").submit();--%>
<%--    }--%>

<%--</script>--%>
<%--<script type="text/javascript">--%>
<%--    function myFunction(message) {--%>
<%--        if (message) {--%>
<%--            $('#exampleModal').modal('show');--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
