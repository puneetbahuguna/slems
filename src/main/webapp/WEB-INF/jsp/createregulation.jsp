<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    }


    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: 100%;
        padding: 15px;
      }
      .row.content {height:100%;}
    }
	input[type=text],input[type=date],select {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
button {
  background-color: #118aef;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
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
      <h2>Create Regulation</h2>
	  <form action="/createregulation" method="post">
      <div class="row gap">
      <input type="text" oninvalid="alert('Please Enter Regulation Type');" placeholder="Enter Regulation Type*" name="rltype" maxlength="15"  required>
	  </div>
	  <div class = "row">
	  <input type="text" oninvalid="alert('Please Enter Regulation Details');" placeholder="Enter Regulation Details*" name="rldetails" maxlength="250" required>
	  </div>
      <div class="row">
      <input type="text" onfocus="(this.type='date')" oninvalid="alert('Please Select Creation Date');" id="dob" placeholder="Select Creation Date*" name="cdate" required>
      </div>
	  <div class="row">
            <select name="deptid" required oninvalid="alert('Please Select Department Name');">
            <option value="" disabled selected>Select Department*</option>
           <c:forEach items="${deptlist}" var="dept">
                                 <option value="${dept.DEPARTMENT_ID}">
                                     ${dept.DEPARTMENT_NM}
                                 </option>
                             </c:forEach>
            </select>
            </div>
	   <div class="row">
	    <button type="submit">Submit</button>
	   </div>
	   <span style="color: blue;margin-top:15px;"><b>${msg}</b></span>
	   </form>
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
