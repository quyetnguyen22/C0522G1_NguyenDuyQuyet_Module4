package com.casestudy.service.impl.service;

import com.casestudy.model.service.Services;
import com.casestudy.repository.service.IServiceRepository;
import com.casestudy.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public List<Services> showAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Services addNewService(Services service) {
        return serviceRepository.save(service);
    }

    @Override
    public Services editService(Services service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Services searchById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Page<Services> searchService(Pageable pageable, Services service) {
        return serviceRepository.findByServiceName(pageable, service);
    }
}
