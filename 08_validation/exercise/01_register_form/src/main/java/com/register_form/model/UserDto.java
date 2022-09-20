package com.register_form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private Integer id;
    @Size(min = 5, max = 45,message = "Please input from 5-45 letters")
    private String firstName;
    @Size(min = 5, max = 45,message = "Please input from 5-45 letters")
    private String lastName;
    //    Phonenumber đúng quy tắc của sđt
//    @NotBlank(message = "Can not be empty")
    private String phoneNumber;
    @Min(value = 18,message = "Age must be equal or greater than 18")
    private String age;
    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$",
            message = "Email is not right format.")
//    @NotBlank(message = "Can not be empty")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
      if (!userDto.phoneNumber.matches("0[0-9]{9}")){
          errors.rejectValue("phoneNumber", "phoneNumber.regex", "Phone number is not right format");
      }
    }
}
