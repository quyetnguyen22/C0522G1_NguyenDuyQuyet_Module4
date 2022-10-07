package com.casestudy.service.impl.service;

import com.casestudy.model.service.ServiceAttach;
import com.casestudy.repository.service.IServiceAttachRepository;
import com.casestudy.service.service.IServiceAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAttachService implements IServiceAttachService {

    @Autowired
    private IServiceAttachRepository attachRepository;

    @Override
    public List<ServiceAttach> getListServiceAttach() {
        return attachRepository.findAll();
    }
}
