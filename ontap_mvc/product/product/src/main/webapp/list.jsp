<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/29/2023
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>

<table class="table table-striped">
    <thread>
    <tr>
      <th>Id</th>
      <th>Name Product</th>
      <th>Price Product</th>
      <th>Description</th>
      <th>Producer</th>
      <th>Delete</th>

  </tr>
    </thread>
    <tbody>
    <c:forEach var="product" items="${productList}">
    <tr>
        <td>${product.getId()}</td>
        <td>${product.getNameProduct()}</td>
        <td>${product.getPriceProduct()}</td>
        <td>${product.getDescription()}</td>
        <td>${product.getProducer()}</td>
        <!-- Button trigger modal -->
        <td>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${product.getId()}">
                Delete
            </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal${product.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title " id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Bạn có chắc  xóa không ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                        <button type="button" class="btn btn-primary" onclick="window.location.href='/product?action=delete&id=${product.getId()}'">Yes</button>
                    </div>
                </div>
            </div>
        </div>
        </td>
    </tr>

    </c:forEach>

    </tbody>
</table>
<button type="button" class="btn btn-outline-secondary"    onclick="window.location.href='/product?action=create' ">Create</button>
</body>
</html>
