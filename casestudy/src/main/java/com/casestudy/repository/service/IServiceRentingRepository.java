package com.casestudy.repository.service;

import com.casestudy.model.service.ServiceRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRentingRepository extends JpaRepository<ServiceRenting, Integer> {

}
