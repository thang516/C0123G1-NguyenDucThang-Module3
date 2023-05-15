<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 5/14/2023
  Time: 4:19 PM
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
<form action="/contract?action=find" method="post">
  <input name="nameFind" placeholder="nhập tên">
<%--  <select name="searchOriginName" >--%>
<%--    <option value="">Chọn Nguồn gốc</option>--%>
<%--    <c:forEach var="product" items="${productList}">--%>
<%--      <option value="${product.id}">${product.name}</option>--%>
<%--    </c:forEach>--%>
<%--  </select>--%>
  <button type="submit">Search</button>
</form>
<table class="table table-striped">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Name Contract</th>
    <th>Date Start</th>
    <th>Date End</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach  var="contract" items="${contractList}">
  <tr>
    <td>${contract.getId()}</td>
    <td>${contract.getName()}</td>
    <td>${contract.getTypeContract().getNameContract()}</td>
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
              <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              Bạn có mún xóa ko ?
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
              <form action="/contract?action=delete&id=${contract.getId()}" method="post">
                <button type="submit" class="btn btn-primary">Yes</button>
              </form>
            </div>
          </div>
        </div>
      </div>


    </td>
  </tr>
  </c:forEach>
  </tbody>
</table>
<button class="btn btn-primary" onclick="window.location.href='/contract?action=create'" >CRETE</button>

</body>
</html>
