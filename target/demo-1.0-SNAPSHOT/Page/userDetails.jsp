<%--
  Created by IntelliJ IDEA.
  User: RAZON'S PC
  Date: 3/31/2022
  Time: 7:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <td>${user.id}</td>
    </tr>
    <tr>
        <th>USERNAME</th>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <th>FULLNAME</th>
        <td>${user.fullName}</td>
    </tr>
    <tr>
        <th>Password</th>
        <td>${user.password}</td>
    </tr>

    <a href="user?page=userEdit&id=${user.id}">EDIT</a>
    <a href="user?page=userDelete&id=${user.id}">DELETE</a>
</table>

</body>
</html>
