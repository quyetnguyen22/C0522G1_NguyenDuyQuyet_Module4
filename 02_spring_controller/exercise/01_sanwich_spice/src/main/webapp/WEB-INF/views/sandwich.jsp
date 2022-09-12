<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich Condiments</h3>

<form action="/choose" >
    <input type="checkbox" id="lettuce" name="condiments" value="Lettuce">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="tomato" name="condiments" value="Tomato">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="mustard" name="condiments" value="Mustard">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="sprouts" name="condiments" value="Sprouts">
    <label for="sprouts">Sprouts</label> <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
