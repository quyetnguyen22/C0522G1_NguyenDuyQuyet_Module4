package com.casestudy.repository.customer;

import com.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where is_deleted = 0 and name like %:search%", nativeQuery = true)
    Page<Customer> findByName(Pageable pageable, String search);

//    countQuery = "select count(*) from (select * from customer where name like %:search% and is_deleted = 0)"
    @Query(value = "select * from customer where is_deleted = 0", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set is_deleted = 1 where id = :delId", nativeQuery = true)
    void delete(@Param("delId") int id);
}
