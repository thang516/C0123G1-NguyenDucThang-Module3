<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/15/2023
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/contract?action=create" method="post">

  <label>Name</label>
    <input class="form-control" type="text" name="name">
  <label>Id contract</label>
    <input class="form-control" type="number" name="idContract">

  <label>Date Start</label>
  <input type="date" name="dateStart">
  <label>Date End</label>
  <input type="date" name="dateEnd">
  <button class="btn btn-primary" type="submit">Create</button>
</form>
</body>
</html>
