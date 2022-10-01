package com.casestudy.service.employee;

import com.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> showAllEmployee(Pageable pageable, String search);

    Optional<Employee> searchById(int id);

    Page<Employee> searchEmployee(Pageable pageable,Employee employee);

    Employee editEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee addNewEmployee(Employee employee);
}
