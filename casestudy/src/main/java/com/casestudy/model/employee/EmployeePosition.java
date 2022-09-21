package com.casestudy.model.employee;

public class EmployeePosition {
    private Integer id;
    private String positionName;

    public EmployeePosition() {
    }

    public EmployeePosition(int id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
