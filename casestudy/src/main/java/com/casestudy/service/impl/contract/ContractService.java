package com.casestudy.service.impl.contract;

import com.casestudy.dto.IContractDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.repository.contract.IContractRepository;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<IContractDto> showAllContract(Pageable pageable, String search) {
        return contractRepository.findAllDto(pageable, search);
    }

    @Override
    public Contract addNewContract(Contract contract) {
        return contractRepository.save(contract);
    }
}
