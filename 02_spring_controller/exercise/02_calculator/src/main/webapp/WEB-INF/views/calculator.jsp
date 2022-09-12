<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Calculator</h3>
<form action="/calculator">
    <input type="text" name="num1">
    <input type="text" name="num2"> <br>
    <h4>Result: <input type="text" disabled value="${result}"></h4>
    <button type="submit" name="cal" value="+">Addition(+)</button>
    <button type="submit" name="cal" value="-">Subtraction(-)</button>
    <button type="submit" name="cal" value="x">Multiplication(x)</button>
    <button type="submit" name="cal" value="/">Division(/)</button>
</form>

</body>
</html>
