package com.example.phone.service.impl;

import com.example.phone.model.Phone;
import com.example.phone.repository.IPhoneRepository;
import com.example.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(int id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void remove(int id) {
        phoneRepository.deleteById(id);
    }
}
