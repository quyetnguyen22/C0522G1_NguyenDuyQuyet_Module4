package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.EmployeeDepartment;
import com.casestudy.repository.employee.IEmployeeDepartmentRepository;
import com.casestudy.service.employee.IEmployeeDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDepartmentService implements IEmployeeDepartmentService {

    @Autowired
    private IEmployeeDepartmentRepository departmentRepository;
    @Override
    public List<EmployeeDepartment> getEmployeeDepartment() {
        return departmentRepository.findAll();
    }
}
