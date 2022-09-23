package com.cart.service.impl;

import com.cart.model.Flower;
import com.cart.repository.IFlowerRepository;
import com.cart.service.IFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService implements IFlowerService {

    @Autowired
    private IFlowerRepository flowerRepository;

    public List<Flower> showAllFlower() {
        return flowerRepository.findAll();
    }

    public Optional<Flower> showFlowerById(int id) {
        return flowerRepository.findById(id);
    }
}
