<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<fieldset>
    <legend>Calculator</legend>
    <form action="/ServletCalculator " method="post">
        <tr>
            <td><h2>First operand</h2></td>
            <td><input type="text" name="firstOperand"></td>
        </tr>

        <tr>
            <td><h2>Operator</h2></td>
            <td><select name="operator">
                <option value="addition">Addition</option>
                <option value="subtraction">Subtraction</option>
                <option value="multiplication">multiplication</option>
                <option value="division">division</option>
            </select>
            </td>
        </tr>
        <tr>
            <td><h2>Second operand</h2></td>

            <td><input type="text" name="secondOperand"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Calculate</button>
            </td>
        </tr>

    </form>
</fieldset>
<h1>Kết quả : ${result}</h1>
${
exception
}



</body>
</html>