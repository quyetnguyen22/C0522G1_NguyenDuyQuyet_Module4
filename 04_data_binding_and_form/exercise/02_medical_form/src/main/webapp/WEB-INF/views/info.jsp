<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/medicalForm" method="get">
    <label>Họ tên:</label>
    <span style="color: blue">${medicalForm.fullName}</span> <br>
    <label>Năm sinh:</label>
    <span style="color: blue">${medicalForm.dateOfBirth}</span> <br>
    <label>Gới tính:</label>
    <span style="color: blue">${medicalForm.gender}</span> <br>
    <label>Quốc tịch:</label>
    <span style="color: blue">${medicalForm.nationality}</span> <br>
    <label>Giấy tờ tùy thân:</label>
    <span style="color: blue">${medicalForm.idNumber}</span> <br>
    <label>Thông tin đi lại:</label>
    <span style="color: blue">${medicalForm.commuteInfo}</span> <br>
    <label>Số hiệu phương tiện:</label>
    <span style="color: blue">${medicalForm.vehicleId}</span> <br>
    <label>Số ghế:</label>
    <span style="color: blue">${medicalForm.seatNumber}</span> <br>
    <label>Ngày khởi hành:</label>
    <span style="color: blue">${medicalForm.beginDate}</span> <br>
    <label>Ngày kết thúc:</label>
    <span style="color: blue">${medicalForm.finishDate}</span> <br>
    <label>Trong vòng 14 ngày qua anh/ chị đã đi đến tỉnh thành phố:</label>
    <span style="color: blue">${medicalForm.stayedCity}</span> <br>
    <button type="submit">Sửa</button>
</form>

</body>
</html>
