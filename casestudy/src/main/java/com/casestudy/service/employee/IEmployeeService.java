package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> showAllEmployee(Pageable pageable, String search);

    List<Employee> findEmployee();

    Optional<Employee> searchById(int id);

    void editEmployee(Employee employee);

    void deleteEmployee(int id);

    void addNewEmployee(Employee employee);
}
