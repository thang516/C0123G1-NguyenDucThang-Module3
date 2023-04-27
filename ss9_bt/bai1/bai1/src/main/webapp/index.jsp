<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
</head>
<body>
<div id="content">
    <form action="ServletProductC2" method="post">
        <div id="data">
            <label > Product Description</label>
            <input type="text" name="description" style="width: 100px">
            <br>
            <label>List Price</label>
            <input type="text" name="price" style="width: 167px">
            <br>
            <label >Discount Percent</label>
            <input type="text" name="discount" style="width: 119px" >
        </div>
        <div>
            <br>
            <input type="submit" value="calculateDiscount">
        </div>
    </form>
</div>


</body>
</html>