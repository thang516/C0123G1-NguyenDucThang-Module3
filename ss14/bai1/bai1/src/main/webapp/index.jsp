<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>


<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Giải phương trình bậc 2</h1>
<form action="/equal" method="post" >
<p>Nhập hệ số bậc 2 :<input type="number" name="a"></p>
<p>Nhập hệ số bậc 1 :<input type="number" name="b"></p>
<p>Nhập hệ số tự do :<input type="number" name="c"></p><br>

<button class="btn btn-outline-primary" type="submit">Submit</button>

</form>
<h1>Kết quả :${message} </h1>
</body>
</html>