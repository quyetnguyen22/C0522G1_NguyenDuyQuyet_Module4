package com.casestudy.model.contract;

import com.casestudy.model.service.ServiceAttach;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "service_attach_id", referencedColumnName = "id")
    private ServiceAttach serviceAttach;


    public ContractDetail() {
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
