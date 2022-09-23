package com.cart.service;

import com.cart.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFlowerService {

    List<Flower> showAllFlower();

    Optional<Flower> showFlowerById(int id);
}
