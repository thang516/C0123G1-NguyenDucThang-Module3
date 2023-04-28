<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/28/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh Sách Sản Phẩm</h1>
<table class="table table-striped ">
    <thread>
        <tr>
            <th>Stt</th>
            <th>ID</th>
            <th>Name Product</th>
            <th>Price Product</th>
            <th>Description</th>
            <th>Producer</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach var="product" items="${productList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.getId()}</td>
            <td>${product.getNameProduct()}</td>
            <td>${product.getPriceProduct()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProducer()}</td>
            <td>
<%--                <button type="submit" class="btn btn-outline-info" onclick="window.location.href='/product?action=delete&id=${product.getId()}'">Delete</button>--%>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#exampleModal${product.getId()}">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal${product.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có chắc xóa không ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                <button type="button" class="btn btn-primary" onclick="window.location.href='/product?action=delete&id=${product.getId()}'">Yes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button type="submit" class="btn btn-outline-success" onclick="window.location.href='/product?action=edit&idEdit=${product.getId()}'">Edit</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<button type="button" class="btn btn-outline-info" onclick="window.location.href='/product?action=create' ">Create
</button>
</body>
</html>
