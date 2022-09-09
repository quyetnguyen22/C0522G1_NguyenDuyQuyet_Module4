package com.currency.repository.impl;

import com.currency.repository.IExchangeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRepository implements IExchangeRepository {
    @Override
    public double exchange(double amount) {
        return amount * 23000;
    }
}
