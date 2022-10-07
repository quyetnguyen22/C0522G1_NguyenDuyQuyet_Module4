package com.casestudy.service.contract;

import com.casestudy.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> getListContractDetail();

    void addNewContractDetail(ContractDetail contractDetail);
}
