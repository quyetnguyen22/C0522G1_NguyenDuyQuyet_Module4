package com.casestudy.service.impl.customer;

import com.casestudy.model.customer.CustomerRank;
import com.casestudy.repository.customer.ICustomerRankRepository;
import com.casestudy.service.customer.ICustomerRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerRankService implements ICustomerRankService {

    @Autowired
    private ICustomerRankRepository customerRankRepository;


    @Override
    public Page<CustomerRank> showAllCustomerRank(Pageable pageable) {
        return customerRankRepository.findAll(pageable);
    }
}
