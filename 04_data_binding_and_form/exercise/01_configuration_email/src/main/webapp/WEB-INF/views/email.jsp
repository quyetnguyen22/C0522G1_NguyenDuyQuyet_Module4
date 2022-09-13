<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Setting</h3>
<form:form action="/email/save" method="get" modelAttribute="email">
    <table class="table">
        <tr>
            <td>Language</td>
            <td>
                <form:select path="languages" items="${language}"/>
            </td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>Show<form:select path="pageSize" items="${pageSize}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><form:button>Save</form:button></td>
            <td><form:button>Cancel</form:button></td>
        </tr>
    </table>

</form:form>
</body>
</html>
