package com.casestudy.service.impl.service;

import com.casestudy.model.service.Services;
import com.casestudy.repository.service.IServiceRepository;
import com.casestudy.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<Services> showAllService(Pageable pageable, String search) {
        return serviceRepository.findAll(pageable, search);
    }

    @Override
    public List<Services> findServiceByDto() {
        return serviceRepository.findByDto();
    }

    @Override
    public void addNewService(Services service) {
        serviceRepository.save(service);
    }

    @Override
    public void editService(Services service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.delete(id);
    }

    @Override
    public Optional<Services> searchById(int id) {
        return serviceRepository.findById(id);
    }

}
