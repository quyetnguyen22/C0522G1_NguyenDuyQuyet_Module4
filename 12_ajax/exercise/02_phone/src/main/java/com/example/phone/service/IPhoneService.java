package com.example.phone.service;

import com.example.phone.model.Phone;

import java.util.Optional;

public interface IPhoneService {

    Iterable<Phone> findAll();

    Optional<Phone> findById(int id);

    Phone save(Phone phone);

    void remove(int id);
}
