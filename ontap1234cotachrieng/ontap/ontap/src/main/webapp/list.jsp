<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/2/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>



<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-striped">
<thread>
    <tr>
        <th>Mã dịch vụ</th>
        <th>Mã loại dịch vu</th>
        <th>ten loai dich vu</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
</thread>
    <tbody>
    <c:forEach var="typeService" items="${typeServiceList}" >
        <tr>
            <td>${typeService.getMaDichVu()}</td>
            <td>${typeService.getMaLoaiDichVu()}</td>
            <td>${typeService.getTenLoaiDichVu()}</td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${typeService.getMaDichVu()}" onclick="handleDelete(${typeService.getMaDichVu()})">
                    Delete
                </button>
            </td>
            <td>
                <button class="btn btn-outline-primary" onclick="window.location.href='/type-service?action=edit&maDichVuEdit=${typeService.getMaDichVu()}'">Edit</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<!-- Modal -->
<div class="modal fade deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có  chắc là xóa ko
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Ko</button>
                <button type="button" class="btn btn-primary"  onclick="confirmDelete()">Có</button>
            </div>
        </div>
    </div>
</div>

<button type="button" class="btn btn-outline-primary" onclick="window.location.href='/type-service?action=create'" >create</button>
<script>
    const deleteModal = document.getElementsByClassName('deleteModal')[0]; // lấy modal
    let idDelete = -1; // đi với thg confirm
    function handleDelete(id){
        idDelete = id;
        deleteModal.removeAttribute('id');
        deleteModal.setAttribute('id', 'exampleModal'+id);
    }
    function confirmDelete() {
        window.location.href='/type-service?action=delete&maDichVu='+idDelete
    }
</script>
</body>
</html>
