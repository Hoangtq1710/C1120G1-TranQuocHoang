<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18-Mar-21
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #046056; width: 100%">
    <a class="navbar-brand" href="#"><i class="fas fa-home"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-------------------navbar----------------------------------------------------------------->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/service">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contract">Contract</a>
            </li>
            <!--            them Search-->
        </ul>
    </div>

    <!-------------------search----------------------------------------------------------------->
    <div>
        <form method="get" style="float: right" class="input-group">
            <input type="text" name="country" id="search" class="form-control" placeholder="Search ...">

            <div class="input-group-append" style="padding-left: 5px">
                <button type="submit" class="btn btn-outline-light">
                    <i class="fas fa-search"></i>
                </button>
                <input name="action" value="search" hidden>
            </div>
        </form>
    </div>
</nav>
