<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/26/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="content">
  <form action="/ServletProduct" method="post">
    <div id="data">
      <label > Product Description</label>
      <input type="text" name="description">
      <br>
      <label>List Price</label>
      <input type="text" name="price">
      <br>
      <label >Discount Percent</label>
      <input type="text" name="discount">
    </div>
    <div>
      <br>
      <input type="submit" value="calculate discount">
    </div>
  </form>
</div>
</body>
</html>
