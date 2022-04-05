<%--
  Created by IntelliJ IDEA.
  User: RAZON'S PC
  Date: 3/29/2022
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <title></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">


</head>
<body>

<form action = "user?page=editUser" method ="POST">
    <input type="hidden" name="id" value="${user.id}">
    <div class="container py-10">
    <div class="form-group d-md-flex">

        <label for="exampleInputUsername">Username</label>
        <input type="text" name="userName" value="${user.userName}" required="" class="form-control" id="exampleInputUsername" aria-describedby="emailHelp" placeholder="Enter Username">
        <small id="UserName" class="form-text text-muted"></small>
    </div>
    <div class="form-group">
        <label for="exampleInputfullName">fullName</label>
        <input type="text" name="fullName" value="${user.fullName}" required="" class="form-control" id="exampleInputfullName" placeholder=" Enter Password">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" value="${user.password}" required="" class="form-control" id="exampleInputPassword1" placeholder=" Enter Password">
    </div>


    <button type="submit" class="btn btn-primary">UPDATE USER</button>

    </div>
</form>



</body>


</html>

