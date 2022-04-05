<%--
  Created by IntelliJ IDEA.
  User: RAZON'S PC
  Date: 3/29/2022
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>

<body class="img js-fullheight" style="background-image: url(images/bg1.jpg); ">
<div class="container-fluid" >
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">

<form action = "user?page=register" method ="POST">
    <div class="form-group d-md-flex">
        <h1>Register Account</h1>
        <div class="w-50"></div>
        <label for="exampleInputUsername">Username</label>
        <input type="text" name="userName" required="" class="form-control" id="exampleInputUsername" aria-describedby="emailHelp" placeholder="Enter Username">
        <small id="emailHelp" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputFullName">FullName</label>
        <input type="text" name="fullName" required="" class="form-control" id="exampleInputFullName" aria-describedby="emailHelp1" placeholder=" Enter FullName">
        <small id="emailHelp1" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword">Password</label>
        <input type="password" name="password" required="" class="form-control" id="exampleInputPassword" placeholder=" Enter Password">
    </div>

    <button type="submit" class="btn btn-primary">Register Now</button>
    <a href = "user>?page=index">Already a Member?<b>LOGIN</b></a>

</form>
        </div>
    </div>
</div>



</body>
</html>

</body>
</html>
