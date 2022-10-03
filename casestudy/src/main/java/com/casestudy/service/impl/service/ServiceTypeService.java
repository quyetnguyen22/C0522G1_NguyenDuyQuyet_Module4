package com.casestudy.service.impl.service;

import com.casestudy.model.service.ServiceType;
import com.casestudy.repository.service.IServiceTypeRepository;
import com.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
     private IServiceTypeRepository typeRepository;

    @Override
    public List<ServiceType> showAllServiceType() {
        return typeRepository.findAll();
    }
}
