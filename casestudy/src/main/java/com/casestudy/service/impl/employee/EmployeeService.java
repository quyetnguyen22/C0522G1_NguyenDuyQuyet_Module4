package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Services;
import com.casestudy.repository.employee.IEmployeeRepository;
import com.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> showAllEmployee(Pageable pageable, String search) {
        return employeeRepository.findAll(pageable, search);
    }

    @Override
    public List<Employee> findEmployeeByDto() {
        return employeeRepository.findByDto();
    }

    @Override
    public Optional<Employee> searchById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
