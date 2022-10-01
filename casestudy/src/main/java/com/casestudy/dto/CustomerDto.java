package com.casestudy.dto;

import com.casestudy.model.customer.CustomerRank;

public class CustomerDto {
    private Integer id;

    private String name;
    private String birthday;
    private String gender;
    private String idNum;
    private String phone;
    private String email;
    private String address;
    private CustomerRank rank;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String birthday, String gender, String idNum, String phone,
                       String email, String address, boolean isDeleted, CustomerRank rank) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNum = idNum;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.rank = rank;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public CustomerRank getRank() {
        return rank;
    }

    public void setRank(CustomerRank rank) {
        this.rank = rank;
    }
}
