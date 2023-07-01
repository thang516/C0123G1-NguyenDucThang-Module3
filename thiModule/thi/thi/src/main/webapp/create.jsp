<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/14/2023
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/manage?action=create" method="post">


<%--  equired onchange="checkName('name', 'errorName')--%>
  <label> Tên tài khoản </label>
<%--  <input class="form-control" type="text" name="user"  required>--%>
  <select class="form-control"  name="user" id="" required>
    <option value="thang">thang</option>
    <option value="adz">adz</option>
    <option value="vien">vien</option>
  </select>
<%--  <small id="errorName"></small>--%>
  <label>Số Đăng kí Nuôi</label>
  <select class="form-control"  name="id" id="" required>
    <option value="1">1</option>
    <option value="2">2</option>
  </select>
<%--  <input class="form-control" type="number" name="id" required >--%>
  <label>Mô tả lỗi vi phạm</label>
  <input class="form-control" type="text" name="information" required>
  <label>Ngày giờ vi phạm </label>
  <input class="form-control" type="text" name="dateTime" required>
  <label>Tiền đóng phạt </label>
  <input class="form-control" type="text" name="money" required>

  <button class="btn btn-primary" type="submit">Create</button>

  <button class="btn btn-outline-primary" type="button">Back</button>
</form>
<%--<script src="regex.js"></script>--%>
</body>
</html>
