<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>
<form:form action="/info" modelAttribute="medicalForm" method="get">
    <label for="name">Họ tên(ghi chữ IN HOA)(*)</label> <br>
    <form:input path="fullName" id="name"/>  <br>
    <form:errors path="fullName" cssClass="error"/>
    <label for="birthday">Năm sinh</label> <br>
    <form:input path="dateOfBirth" id="birthday"/>
    <form:errors path="dateOfBirth" cssClass="error"/>
    <label for="gender">Gới tính</label>
    <form:select path="gender" items="${gender}"/>
    <form:errors path="gender" cssClass="error"/>
    <label for="nationalities">Quốc tịch</label>
    <form:select path="nationality" items="${nationality}" id="nationalities"/> <br>
    <form:errors path="nationality" cssClass="error"/>
    <label for="idNum">Giấy tờ tùy thân</label> <br>
    <form:input path="idNumber" id="idNum"/> <br>
    <form:errors path="idNumber" cssClass="error"/>
    <label for="move">Thông tin đi lại</label> <br>
    <form:radiobuttons path="commuteInfo" items="${commute}" id="move"/> <br>
    <form:errors path="commuteInfo" cssClass="error"/>
    <label for="vehicle">Số hiệu phương tiện</label> <br>
    <form:input path="vehicleId" id="vehicle"/> <br>
    <label for="seat">Số ghế</label> <br>
    <form:input path="seatNumber" id="seat"/> <br>
    <label for="begin">Ngày khởi hành</label> <br>
    <form:input path="beginDate" id="begin"/> <br>
    <form:errors path="beginDate" cssClass="error"/>
    <label for="end">Ngày kết thúc</label> <br>
    <form:input path="finishDate" id="end"/> <br>
    <form:errors path="finishDate" cssClass="error"/>
    <label for="city">Trong vòng 14 ngày qua anh/ chị đã đi đến tỉnh thành phố nào?</label> <br>
    <form:input path="stayedCity" id="city"/> <br>
    <form:errors path="stayedCity" cssClass="error"/>
<button type="submit">Lưu</button>
</form:form>
</body>
</html>
