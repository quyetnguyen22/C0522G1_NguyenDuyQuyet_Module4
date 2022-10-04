package com.casestudy.repository.contract;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where customer_id like %:search%", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable, @Param("search") String search);

//    @Query(value = "select s.name, cus.name, c.begin, c.end, c.deposit, c.total from   ")
//    List<Contract> getContractByDto();


}
