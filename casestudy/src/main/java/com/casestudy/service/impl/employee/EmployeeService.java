package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> showAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee searchById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> searchEmployee(Pageable pageable, Employee employee) {
        return employeeRepository.findEmployeeByEmployeeName(pageable,employee);
    }

    @Override
    public Employee editEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }
}
