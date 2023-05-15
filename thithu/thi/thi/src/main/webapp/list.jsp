<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/15/2023
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/contract?action=find" method="post">
    <label>Nhậpteen</label>
    <input type="text" name="nameFind">
    <label>nhập tên của HOp Đồng </label>
    <input type="text" name="nameContract">
    <button class="btn btn-outline-primary" type="submit">FIND </button>
</form>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Name Contract</th>
        <th>Date Start</th>
        <th>Date End</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contract" items="${contractList}">
    <tr>
        <td>${contract.getId()}</td>
        <td>${contract.getName()}</td>
        <td>${contract.getTypeContract().getContractName()}</td>
        <td>${contract.getDateStart()}</td>
        <td>${contract.getDateEnd()}</td>
        <td>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${contract.getId()}">
                Delete
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal${contract.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Bạn có muốn xóa ko ?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ko </button>
                            <form action="/contract?action=delete&id=${contract.getId()}" method="post">
                            <button type="submit" class="btn btn-primary">CÓ</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </td>
        <td>
            <button class="btn btn-primary" type="submit" onclick="window.location.href='/contract?action=edit&idEdit=${contract.getId()}'">Edit</button>
        </td>
    </tr>

    </c:forEach>
    </tbody>

</table>
<h2>${mess}</h2>
<button class="btn btn-primary" onclick="window.location.href='/contract?action=create'">Create</button>
</body>
</html>
