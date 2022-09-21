package com.casestudy.service.customer;

import com.casestudy.model.customer.CustomerRank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerRankService {
    Page<CustomerRank> showAllCustomerRank(Pageable pageable);
}
