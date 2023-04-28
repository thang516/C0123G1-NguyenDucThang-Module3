<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/28/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<body>

<form method="post" >

    <label> Name Product</label>
    <input  class="form-control" type="text" name="nameProduct" value="${nameProduct}" required>
    <label>Price Product</label>
    <input class="form-control" type="text" name="priceProduct" value="${priceProduct} required"><br>
    <label> Description</label>
    <input class="form-control"  type="text" name="description" value="${description}" required> <br>
    <label> Producer</label>
    <input class="form-control" type="text" name="producer" value="${producer}" required> <br>

    <button class="btn btn-outline-success" type="submit">Edit</button>

</form>
</body>
</html>
