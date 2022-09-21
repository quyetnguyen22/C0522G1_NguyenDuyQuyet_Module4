package com.casestudy.repository.service;

import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services, Integer> {
    Services findById(int id);

    Page<Services> findByServiceName(Pageable pageable, Services service);
}
