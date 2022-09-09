package com.currency.service.impl;

import com.currency.repository.IExchangeRepository;
import com.currency.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {
    @Autowired
    IExchangeRepository exchangeRepository;
    @Override
    public double exchange(double amount) {
        return exchangeRepository.exchange(amount);
    }
}
