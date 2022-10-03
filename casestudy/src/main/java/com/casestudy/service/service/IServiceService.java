package com.casestudy.service.service;

import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService {
    Page<Services> showAllService(Pageable pageable, String search);
    List<Services> findServiceByDto();
    void addNewService(Services service);
    void editService(Services service);
    void deleteService(int id);
    Optional<Services> searchById(int id);

}
