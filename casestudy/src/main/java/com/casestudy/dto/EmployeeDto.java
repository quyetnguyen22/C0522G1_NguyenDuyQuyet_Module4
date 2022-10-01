package com.casestudy.dto;

import com.casestudy.model.employee.EmployeeDepartment;
import com.casestudy.model.employee.EmployeeEduLevel;
import com.casestudy.model.employee.EmployeePosition;

public class EmployeeDto {

    private Integer id;

    private String name;
    private String birthday;
    private String idNumber;
    private String phone;
    private String email;
    private String salary;
    private String address;

    private EmployeeDepartment department;

    private EmployeeEduLevel eduLevel;

    private EmployeePosition position;

    public EmployeeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EmployeeDepartment department) {
        this.department = department;
    }

    public EmployeeEduLevel getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(EmployeeEduLevel eduLevel) {
        this.eduLevel = eduLevel;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }
}
