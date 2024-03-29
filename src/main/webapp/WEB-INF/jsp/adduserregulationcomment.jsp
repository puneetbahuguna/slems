<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	input[type=text] {
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
        <li class="active"><a href="employee">Home</a></li>
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
      <h2>Regulations Details</h2>
            <div class="row">
            <table>
            <tr>
            <th>ID</th>
            <th>RL Type</th>
            <th>Details</th>
            <th>Creation Date</th>
            <th>Department</th>
            </tr>
            <tr>
            <th>${regulation.COMPLIANCEID}</th>
            <th>${regulation.RLTYPE}</th>
            <th>${regulation.DETAILS}</th>
            <th>${fn:split(regulation.CREATEDDATE, ' ')[0]}</th>
            <th>${regulation.department.DEPARTMENT_NM}</th>
            </tr>
            </table>
            </div>
            <div class="row">
            <table><tr>
            <th>Your Comment</th></tr>
            <tr><th>${commentMsg} ${comdate}</th></tr></table>
            </div>
            <form action="/updateusercomment" method="post">
            <input type="hidden" name="complianceId" value="${regulation.COMPLIANCEID}">
            <input type="hidden" name="actionFlag" value="${commentMsg}">
             <c:choose>
                            <c:when test="${regulation.STATUS=='Closed'}">
                            <div class="row gap">
                            <span style="color: blue;margin-top:15px;"><b>This Regulation is closed now</b></span>
                            </div>
                            </c:when>
                            <c:otherwise>
                            <div class="row gap">
                                         <input type="text" oninvalid="alert('Please Enter Your Comment');" placeholder="Update Your Comments*" name="usercomment" maxlength="15" required>
                                         </div>
                                         <div class="row">
                                         	    <button type="submit">Submit</button>
                                         	   </div>
                            </c:otherwise>
                            </c:choose>
             	   </form>
    </div>
    <div class="col-sm-2 sidenav">
    <div class="loginbox">
    <p><b>Hi ${fullname}</b></p>
    <p><b>Emp ID:${empid}</b></p>
    <p><b>Role:${userrole}</b></p>
    <p><b>Department:${deptname}</b></p>
    </div>

    </div>
  </div>
</div>

</body>
</html>
