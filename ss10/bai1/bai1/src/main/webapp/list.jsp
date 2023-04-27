<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/27/2023
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        img{
            height: 50px;
            width: 50px;
        }

    </style>
</head>
<body>

<h1>Danh Sách Khách Hàng</h1>
<table border="1">
    <tr>

        <th>STT</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Photos</th>

    </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">

            <tr>
                <td>${status.count}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getDateOfBirth()}</td>
                <td>${customer.getAddress()}</td>
                <td><img src="${customer.getPhotos()}" ></td>
            </tr>

        </c:forEach>


</table>


</body>
</html>
