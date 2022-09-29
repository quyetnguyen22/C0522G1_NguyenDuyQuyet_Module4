package com.casestudy.service.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> showAllCustomer(Pageable pageable, String search);

    Optional<Customer> findById(int id);

    Customer editCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer addNewCustomer(Customer customer);
}
