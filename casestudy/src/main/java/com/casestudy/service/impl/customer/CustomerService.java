package com.casestudy.service.impl.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Services;
import com.casestudy.repository.customer.ICustomerRepository;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> showAllCustomer(Pageable pageable, String search) {
        return customerRepository.findAll(pageable, search);
    }

    @Override
    public List<Customer> findCustomerByDto() {
        return customerRepository.findByDto();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
