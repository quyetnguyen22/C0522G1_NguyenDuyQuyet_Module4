<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="get">
    <input type="text" name="vocabulary">
    <button type="submit">Translate</button>
</form>
    <h3>Result: ${vietnam} ${notfound}</h3>

</body>
</html>
