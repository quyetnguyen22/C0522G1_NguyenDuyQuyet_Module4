package com.casestudy.repository.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where is_deleted = 0", nativeQuery = true)
    List<Employee> findByDto();

    @Query(value = "select * from employee where name like %:search% and is_deleted = 0", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable, String search);

    @Transactional
    @Modifying
    @Query(value = "update employee set is_deleted = 1 where id = :delId", nativeQuery = true)
    void deleteById(@Param("delId") int id);
}
