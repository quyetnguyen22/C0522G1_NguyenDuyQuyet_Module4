package com.casestudy.dto;

import com.casestudy.model.customer.CustomerRank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String gender;

    @NotBlank
    @Pattern(regexp = "[0-9]{10}", message = "ID number must be 10 numbers")
    private String idNum;

    @Pattern(regexp = "(0|([(]84[)][+]))(9(0|1)[0-9]{7})",
            message = "Please input following 090xxxxxxx or 091xxxxxxx hoặc (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String phone;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}| *$",
            message = "Please input email following 'abc@domain.com'")
    private String email;

    private String address;
    private CustomerRank rank;

    public CustomerDto() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.name.matches("^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5} *$")) {
            errors.rejectValue("nameRegex", "nameValidation.regex", "Please input name following 'Nguyen Van A'");
        }
//        Date dateNow = Date.valueOf(LocalDate.now());
//        Date birth = Date.valueOf(customerDto.birthday);
//        if (true) {
//            errors.rejectValue("name", "nameValidation.regex","Please input name following 'Nguyen Van A'");
//        }
    }
}
