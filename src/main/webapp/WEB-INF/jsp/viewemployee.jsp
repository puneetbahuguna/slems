<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
  <title>Welcome to EMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
	.well {
    min-height: 20px;
    padding: 19px;
    margin-bottom: 20px;
    background-color: #d9edf7;
    border: 1px solid #e3e3e3;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
}
.loginbox {
    min-height: 20px;
    padding: 10px;
    margin-bottom: 10px;
    background-color: #b7339d;
    border: 1px solid #e3e3e3;
    color: white;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
}

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 555px;}

    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }

    .gap{
    margin-top: 30px;
    margin-bottom:10px;
    }


    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: 100%;
        padding: 15px;
      }
      .row.content {height:100%;}
    }
	table {
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      font-size:12px;
      padding: 8px;
    }
  </style>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="admin">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="relogin"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">
  <div class="row content">
  <div class="col-sm-2 sidenav">

    </div>
    <div class="col-sm-8 text-center">
      <h2>View Employee</h2>
      <table class="gap">
      	<tr><th>ID</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Email</th>
            <th>Department</th>
            <th>Select Action</th>
            </tr>
       <c:forEach items="${emplist}" var="emp">
       <tr>
       <th>${emp.EMPID}</th>
        <th>${emp.FIRSTNAME} ${emp.LASTNAME}</th>
              <th>${fn:split(emp.DOB, ' ')[0]}</th>
              <th>${emp.EMAIL}</th>
       <th>${emp.department.DEPARTMENT_NM}</th>
       <th>
       <a href="editEmployee?empId=${emp.EMPID}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteEmployee?empId=${emp.EMPID}">Delete</a>
       </th>
       </tr>
       </c:forEach>
      	</table>
    </div>
    <div class="col-sm-2 sidenav">
    <div class="loginbox">
    <p><b>Hi ${fullname}</b></p>
    <p><b>Emp ID:${empid}</b></p>
    <p><b>Role:${userrole}</b></p>
    </div>
    </div>
  </div>
</div>

</body>
</html>
