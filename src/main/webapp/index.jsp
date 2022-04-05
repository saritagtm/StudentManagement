<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

        <title>Student Management</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">

    <link rel="stylesheet" href="css/style.css">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    </head>


<body class="img js-fullheight" style="background-image: url(images/bg.jpg); " >
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">



<form action = "user" method ="POST">
    <input type="hidden" name="page" value="login">
    <h1>Student Login</h1>
    <div class="form-group d-md-flex">

        <label for="exampleInputUsername">Username</label>
        <input type="text" name="userName" required="" class="form-control" id="exampleInputUsername" aria-describedby="emailHelp" placeholder="Enter Username">
        <small id="UserName" class="form-text text-muted"></small>
    </div>

    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" name="password" required="" class="form-control" id="exampleInputPassword1" placeholder=" Enter Password">
    </div>
    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Always Remember</label>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <a href="user?page=newUsers">Not a member yet? <b>Register Here</b></a>


</form>
        </div>
    </div>
</div>
</body>
</html>