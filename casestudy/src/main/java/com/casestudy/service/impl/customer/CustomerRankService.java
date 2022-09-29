package com.casestudy.service.impl.customer;

import com.casestudy.model.customer.CustomerRank;
import com.casestudy.repository.customer.ICustomerRankRepository;
import com.casestudy.service.customer.ICustomerRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRankService implements ICustomerRankService {

    @Autowired
    private ICustomerRankRepository customerRankRepository;


    @Override
    public List<CustomerRank> showAllCustomerRank() {
        return customerRankRepository.findAll();
    }
}
