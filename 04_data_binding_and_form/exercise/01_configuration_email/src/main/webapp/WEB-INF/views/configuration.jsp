<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/email/edit">
    <table class="table">
        <tr>
            <td>Language</td>
            <td>${email.languages}</td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>${email.pageSize}</td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>${email.spamsFilter}</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>${email.signature}</td>
        </tr>
        <tr>
            <td><button>Edit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
