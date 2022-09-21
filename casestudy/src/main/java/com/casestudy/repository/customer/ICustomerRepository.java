package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int id);
}
