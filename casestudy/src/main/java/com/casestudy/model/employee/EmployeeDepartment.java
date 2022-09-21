package com.casestudy.model.employee;

public class EmployeeDepartment {
    private Integer id;
    private String departmentName;

    public EmployeeDepartment() {
    }

    public EmployeeDepartment(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
