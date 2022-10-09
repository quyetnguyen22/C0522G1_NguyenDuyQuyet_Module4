package com.casestudy.repository.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    //    @Query(value = "select * from contract where customer_id like %:search%", nativeQuery = true)
//    Page<Contract> findAll(Pageable pageable, @Param("search") String search);

    @Query(value = "select ctr.id, c.`name` as customerName, s.`name` as serviceName, ctr.`begin` as beginDate, " +
            "ctr.`end` as endDate, ctr.`deposit` as deposit, " +
            "(ifnull(s.price,0)*datediff(ifnull(ctr.`end`,0),ifnull(ctr.`begin`,0))+ " +
            "sum(ifnull(cd.quantity,0)*ifnull(sa.price,0))+ifnull(ctr.deposit,0)) as totalCost " +
            "from contract as ctr " +
            "left join customer as c on c.id = ctr.customer_id " +
            "left join services s on ctr.service_id = s.id " +
            "left join contract_detail cd on cd.contract_id = ctr.id " +
            "left join service_attach sa on sa.id = cd.service_attach_id " +
            "where c.`name` like %:search% " +
            "group by ctr.id", nativeQuery = true,
            countQuery = "select count(*) from (select ctr.id, c.`name` as customerName, s.`name` as serviceName, ctr.`begin` as beginDate, " +
                    "ctr.`end` as endDate, ctr.`deposit` as deposit, " +
                    "(ifnull(s.price,0)*datediff(ifnull(ctr.`end`,0),ifnull(ctr.`begin`,0))+" +
                    " sum(ifnull(cd.quantity,0)*ifnull(sa.price,0))+ifnull(ctr.deposit,0)) as totalCost " +
                    "from contract as ctr " +
                    "left join customer as c on c.id = ctr.customer_id " +
                    "left join services s on ctr.service_id = s.id " +
                    "left join contract_detail cd on cd.contract_id = ctr.id " +
                    "left join service_attach sa on sa.id = cd.service_attach_id " +
                    "where c.`name` like %:search% " +
                    "group by ctr.id) temp")
    Page<IContractDto> findAllDto(Pageable pageable, @Param("search") String search);


}
