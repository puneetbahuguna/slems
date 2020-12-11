<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<script>
function checkAgeValidation() {
  var Bdate = document.getElementById("dob").value;
  var Bday = +new Date(Bdate);
  var age =  ~~ ((Date.now() - Bday) / (31557600000));
  if(parseInt(age)<24){
  document.getElementById("dob").value="";
  alert("Minimum Employee Age should be 24");}

}
</script>

  <title>Add Employee</title>
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
	input[type=text], input[type=password],input[type=date],input[type=email],select,option {
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
      <h2>Edit Employee</h2>
	  <form action="/editempform" method="post">
	  <input type="hidden" value="${employee.EMPID}" name="empid">
      <div class="row gap">
      <input type="text" value="${employee.FIRSTNAME}" placeholder="Enter First Name*" oninvalid="alert('Please Enter First Name');"
       name="firstname" required>
      </div>
      <div class="row">
      <input type="text" value="${employee.LASTNAME}" placeholder="Enter Last Name*" name="lastname" required oninvalid="alert('Please Enter Last Name');">
      </div>
      <div class="row">
      <input type="text" value="${dob}" onfocus="(this.type='date')" oninvalid="alert('Please Enter DOB');" onchange="checkAgeValidation()" id="dob" placeholder="Enter DOB*" name="dob" required>
      </div>
      <div class="row">
            <input type="email" value="${employee.EMAIL}" placeholder="Enter EMAIL" name="email">
            </div>
      <div class="row">
      <select name="deptid">
     <c:forEach items="${deptlist}" var="dept">
      <c:choose>
                                 <c:when test="${dept.DEPARTMENT_ID==employee.department.DEPARTMENT_ID}">
                                  <option value="${dept.DEPARTMENT_ID}" selected>${dept.DEPARTMENT_NM}</option>
                                 </c:when>
                                 <c:otherwise>
                                 <option value="${dept.DEPARTMENT_ID}">${dept.DEPARTMENT_NM}</option>
                                 </c:otherwise>
                                 </c:choose>
                       </c:forEach>
      </select>
      </div>
      <div class="row">
       <input type="password"  value ="${userpwd}" placeholder="Set Password" name="setpassword" required oninvalid="alert('Please Set Password');">
      </div>
	   <div class="row">
	    <button type="submit">Submit</button>
	   </div>
	   <span style="color: blue;margin-top:15px;"><b>${msg}</b></span>
	   </form>
    </div>
    <div class="col-sm-2 sidenav">
    <p><b>Hi ${fullname}</b></p>
    <p><b>Emp ID:${empid}</b></p>
    <p><b>Role:${userrole}</b></p>

    </div>
  </div>
</div>

</body>
</html>
