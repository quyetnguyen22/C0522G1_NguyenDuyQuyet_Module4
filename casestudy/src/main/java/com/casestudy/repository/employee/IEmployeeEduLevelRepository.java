package com.casestudy.repository.employee;

import com.casestudy.model.employee.EmployeeEduLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeEduLevelRepository extends JpaRepository<EmployeeEduLevel, Integer> {

}
