package com.casestudy.model.contract;

public class Contract {
    Integer id;
    String begin;
    String end;
    String deposit;
    int employeeId;
    int customerId;
    int serviceId;

    public Contract() {
    }

    public Contract(int id, String begin, String end, String deposit, int employeeId, int customerID, int serviceId) {
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.deposit = deposit;
        this.employeeId = employeeId;
        this.customerId = customerID;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
