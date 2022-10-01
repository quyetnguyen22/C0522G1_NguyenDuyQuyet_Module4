package com.casestudy.service.impl.employee;

import com.casestudy.model.employee.EmployeeEduLevel;
import com.casestudy.repository.employee.IEmployeeEduLevelRepository;
import com.casestudy.service.employee.IEmployeeEduLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeEduLevelService implements IEmployeeEduLevelService {

    @Autowired
    private IEmployeeEduLevelRepository eduLevelRepository;

    @Override
    public List<EmployeeEduLevel> getEmployeeEduLevel() {
        return eduLevelRepository.findAll();
    }
}
