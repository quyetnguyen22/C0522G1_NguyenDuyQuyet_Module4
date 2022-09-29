//package com.casestudy.service.impl.contract;
//
//import com.casestudy.model.contract.Contract;
//import com.casestudy.repository.contract.IContractRepository;
//import com.casestudy.service.contract.IContractService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ContractService implements IContractService {
//
//    @Autowired
//    private IContractRepository contractRepository;
//    @Override
//    public Page<Contract> showAllContract(Pageable pageable) {
//        return contractRepository.findAll(pageable);
//    }
//
//    @Override
//    public Contract addNewContract(Contract contract) {
//        return contractRepository.save(contract);
//    }
//}
