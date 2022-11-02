package com.exam_module_4.dto;

import com.exam_module_4.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductsDto implements Validator {

    private Integer id;

    @NotBlank(message = "Can not be empty!")
    @Size(min = 5, max = 50, message = "Name must be from 5-50 characters!")
    private String name;

//    @NotBlank(message = "Can not be empty!")
    private double price;

    @NotBlank(message = "Can not be empty!")
    private String status;

    private ProductType productType;

    public ProductsDto() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
