package com.casestudy.service.service;

import com.casestudy.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Services> showAllService();
    Services addNewService(Services service);
    Services editService(Services service);
    void deleteService(int id);
    Services searchById(int id);
    Page<Services> searchService(Pageable pageable, Services service);
}
