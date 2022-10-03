package com.casestudy.repository.service;

import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Services, Integer> {

    @Query(value = "select * from services where name like %:search% and is_deleted = 0", nativeQuery = true)
    Page<Services> findAll(Pageable pageable, @Param("search") String search);

    @Transactional
    @Modifying
    @Query(value = "update services set is_deleted = 1 where id = :delId", nativeQuery = true)
    void delete(@Param("delId") int id);

    @Query(value = "select * from service where is_delete = 0", nativeQuery = true)
    List<Services> findByDto();
}
