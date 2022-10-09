package com.casestudy.service.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDto> showAllContract(Pageable pageable, String search);

    Contract addNewContract(Contract contract);
}
