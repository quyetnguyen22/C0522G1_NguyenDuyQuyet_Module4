package com.casestudy.repository.employee;

import com.casestudy.model.employee.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {

}
