package com.casestudy.service.contract;

import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> showAllContract(Pageable pageable);
    Contract addNewContract(Contract contract);
}
