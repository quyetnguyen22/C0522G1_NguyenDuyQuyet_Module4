package com.casestudy.service.impl.service;

import com.casestudy.model.service.ServiceRenting;
import com.casestudy.repository.service.IServiceRentingRepository;
import com.casestudy.service.service.IServiceRentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRentingService implements IServiceRentingService {

    @Autowired
    private IServiceRentingRepository rentingRepository;

    @Override
    public List<ServiceRenting> showAllServiceRenting() {
        return rentingRepository.findAll();
    }
}
