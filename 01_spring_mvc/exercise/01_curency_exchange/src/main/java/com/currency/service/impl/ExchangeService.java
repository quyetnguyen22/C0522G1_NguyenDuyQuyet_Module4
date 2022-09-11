package com.currency.service.impl;

import com.currency.service.IExchangeService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {

    @Override
    public double exchange(double amount) {
        return amount * 23000;
    }
}
