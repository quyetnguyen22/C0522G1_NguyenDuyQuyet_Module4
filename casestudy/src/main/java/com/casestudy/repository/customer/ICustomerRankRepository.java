package com.casestudy.repository.customer;

import com.casestudy.model.customer.CustomerRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRankRepository extends JpaRepository<CustomerRank, Integer> {

}
