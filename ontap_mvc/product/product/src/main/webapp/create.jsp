<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/29/2023
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="/product?action=create" method="post">
<label>Nhập Id</label>
<input class="form-control" type="text" name="id" required> <br>
<label>Name Product</label>
<input class="form-control"  type="text" name="nameProduct" required>  <br>
<label>Price Product</label>
<input class="form-control"  type="text" name="priceProduct" required> <br>
<label>Description </label>
<input  class="form-control"  type="text" name="description" required> <br>
<label>Procedure</label>
<input  class="form-control"  type="text" name="producer" required > <br>
<button class="btn btn-outline-primary" type="submit" >Create</button>
</form>
</body>
</html>
