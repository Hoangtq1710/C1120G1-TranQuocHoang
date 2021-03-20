<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common_navbar.jsp" %>

    <!-------------------navbar----------------------------------------------------------------->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link active" href="employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contract">Contract</a>
            </li>
            <!--            them Search-->
        </ul>
    </div>

    <!-------------------search----------------------------------------------------------------->
    <%@include file="search-navbar.jsp" %>

