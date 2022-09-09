<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2022
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/exchange" method="get">
    <input type="text" name="amount">
    <button type="submit">exchange</button>
</form>
<h3>Result: ${result} VND</h3>
</body>
</html>
