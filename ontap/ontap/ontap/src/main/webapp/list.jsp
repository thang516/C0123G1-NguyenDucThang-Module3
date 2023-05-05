<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/4/2023
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>User</h1>
 <table class="table table-striped">
     <thread>
         <tr>
             <td>ID</td>
             <td>Name</td>
             <td>Email</td>
             <td>Country</td>
         </tr>
     </thread>
     <tbody>
     <c:forEach var="user" items="${userList}">
         <tr>
        <td>${user.getId()}</td>
        <td>${user.getName()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getCountry()}</td>
         </tr>
     </c:forEach>
     </tbody>

 </table>
<form action="/users?action=find" method="post">
    <label>Nhập contry</label>
    <input type="text" name="countrys">
    <button type="submit">Search</button>
</form>
<button class="btn btn-outline-primary" onclick="window.location.href='/users?action=create'">Create</button>
</body>
</html>
