<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<h1>${message}</h1>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
h1,h3 {text-align: center;}

/* Set a style for all buttons */
button {
  background-color: #118aef;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}
/* The Modal (background) */
.modal {
  margin:auto;
  width: 50%; /* Full width */
  height: 50%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 50%; /* Could be more or less, depending on screen size */
}
}
</style>
</head>
<body>
<div id="id01" class="">
<h3>Login to continue</h3>
  <form class="modal-content animate" action="/login" method="post">

    <div class="container">
      <label for="uname"><b>EmpID</b></label>
      <input type="text" placeholder="Enter EmpId" name="userid" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>
      <button type="submit">Login</button>

      <span style="color: red;margin-top:15px;"><b>${errormsg}</b></span>

    </div>
  </form>
</div>
</body>
</html>