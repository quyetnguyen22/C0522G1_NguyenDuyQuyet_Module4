//Họ tên Employee, Ngày sinh, Số CMND, Số ĐT, Email, Trình độ, Vị trí, Lương.
package com.casestudy.model.employee;

import com.casestudy.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String birthday;
    private String idNumber;
    private String phone;
    private String email;
    private String salary;
    private String address;
    private boolean isDeleted = false;


    //    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private EmployeeDepartment department;


    //    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "edu_level_id", referencedColumnName = "id")
    private EmployeeEduLevel eduLevel;


    //    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private EmployeePosition position;

    //    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(Integer id, String name, String birthday, String idNumber, String phone, String email,
                    String salary, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.address = address;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
