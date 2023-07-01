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


<%--<link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />--%>
<%--<link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />--%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form action="" method="post">--%>
<%--  <input name="nameFind" placeholder="nhập tên">--%>
<%--  <button type="submit">Search</button>--%>
<%--</form>--%>
<table class="table table-striped" id="table1">
  <thead>
  <tr>

    <th>Mã vé phạt</th>
    <th>Tên tài khoản</th>
    <th>Id thú nuôi </th>
    <th>Lỗi vi phạm </th>
    <th> ngày giờ </th>
    <th>tiền</th>
    <th>ghi chú </th>
    <th>Chức Năng</th>
  </tr>
  </thead>
  <tbody>
<c:forEach var="phat" items="${phatList}">
  <tr>
   <td>${phat.getPhatId()}</td>
   <td>${phat.getUser()}</td>
   <td>${phat.getId()}</td>
   <td>${phat.getInformation()}</td>
   <td>${phat.getDateTime()}</td>
   <td>${phat.getMoney()}</td>
   <td>${phat.getNote()}</td>

    <td>
      <!-- Button trigger modal -->
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Đóng Phạt
      </button>

      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Notification</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             ...
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">..</button>
              <form action="" method="post">
                <button type="submit" class="btn btn-primary">..</button>
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
<button class="btn btn-primary" onclick="window.location.href='/manage?action=create'" >Create</button>

</body>

<%--<script src="jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="datatables/js/dataTables.bootstrap5.min.js"></script>--%>
<%--<script>--%>
<%--  $(document).ready(function() {--%>
<%--    $('#table1').dataTable( {--%>
<%--      "dom": 'lrtip',--%>
<%--      "lengthChange": false,--%>
<%--      "pageLength": 3--%>
<%--    } );--%>
<%--  });--%>
<%--</script>--%>

</html>
