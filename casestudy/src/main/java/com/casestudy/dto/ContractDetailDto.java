package com.casestudy.dto;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.service.ServiceAttach;

public class ContractDetailDto {

    private Integer id;
    private Integer quantity;
    private Contract contract;
    private ServiceAttach serviceAttach;

    public ContractDetailDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ServiceAttach getServiceAttach() {
        return serviceAttach;
    }

    public void setServiceAttach(ServiceAttach serviceAttach) {
        this.serviceAttach = serviceAttach;
    }
}
