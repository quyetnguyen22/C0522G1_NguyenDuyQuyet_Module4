package com.casestudy.rest_controller;

import com.casestudy.dto.ContractDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin("*")
@RequestMapping("contract")
public class ContractRestController {

    @Autowired
    private IContractService contractService;

    @PostMapping("addNew")
    public ResponseEntity<Contract > saveNewContract(@RequestBody ContractDto contractDto,
                                  RedirectAttributes attributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        attributes.addFlashAttribute("add", "Added new contract successfully!");
        return new ResponseEntity<>(contractService.addNewContract(contract), HttpStatus.CREATED);
    }
}
