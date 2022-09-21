package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.EmployeePosition;
import com.casestudy.repository.employee.IEmployeePositionRepository;
import com.casestudy.service.employee.IEmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionService implements IEmployeePositionService {
    @Autowired
    private IEmployeePositionRepository positionRepository;
    @Override
    public List<EmployeePosition> EmployeePosition() {
        return positionRepository.findAll();
    }
}
