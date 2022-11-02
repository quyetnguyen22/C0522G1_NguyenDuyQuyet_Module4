package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> showAllCustomer(Pageable pageable);

    Page<Customer> getCustomer(Pageable pageable, String search);

    Optional<Customer> findById(int id);

    void editCustomer(Customer customer);

    void deleteCustomer(int id);

    void addNewCustomer(Customer customer);
}
