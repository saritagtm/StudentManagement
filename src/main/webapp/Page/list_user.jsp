<%--
  Created by IntelliJ IDEA.
  User: RAZON'S PC
  Date: 3/29/2022
  Time: 7:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../include/navbar.jsp" %>
<a href="user?page=newUsers">Add User</a>
<a href="user?page=editUser">EDIT</a>
<a href="user?page=deleteUser">DELETE</a>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">USERNAME</th>
        <th scope="col">FULLNAME</th>
        <th scope="col">PASSWORD</th>
        <th scope="col">ACTION</th>
    </tr>

    <c:forEach items="${arrayList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.fullName}</td>
            <td>${user.password}</td>
            <td><a href="user?page=userDetails&id=${user.id}">User Details</a></td>
        </tr>
    </c:forEach>

    </thead>

</table>
</body>
</html>
