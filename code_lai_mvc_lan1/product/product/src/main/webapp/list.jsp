<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/13/2023
  Time: 4:10 PM
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
<h1>Student List</h1>
<table class="table table-striped">
<thead>
<tr>

    <th>ID</th>
    <th>Name</th>
    <th>Class</th>
    <th>Point</th>
    <th>Delete</th>
    <th>Edit</th>
</tr>
</thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getClazz().getName()}</td>
            <td>${student.getPoint()}</td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal${student.getId()}">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal${student.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">khong</button>
                            </div>

                                <div class="modal-body">
                                    Bạn có muốn xóa không
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                                    <form action="/student?action=delete&id=${student.getId()}" method="post">
                                    <button type="submit" class="btn btn-primary" >Có</button>
                            </form>
                                </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button class="btn btn-outline-primary" type="button" onclick="window.location.href='/student?action=edit&idEdit=${student.getId()}'" >Edit</button>
            </td>

        </tr>
    </c:forEach>

    </tbody>
</table>
<button class="btn btn-outline-primary" type="submit" onclick="window.location.href='/student?action=create'">Create</button>
</body>
</html>
