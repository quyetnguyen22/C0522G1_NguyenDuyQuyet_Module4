package com.casestudy.service.impl.contract;

import com.casestudy.model.contract.ContractDetail;
import com.casestudy.repository.contract.IContractDetailRepository;
import com.casestudy.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository detailRepository;

    @Override
    public List<ContractDetail> getListContractDetail() {
        return detailRepository.findAll();
    }

    @Override
    public void addNewContractDetail(ContractDetail contractDetail) {
        detailRepository.save(contractDetail);
    }
}
