package com.casestudy.controller;

import com.casestudy.dto.ContractDto;
import com.casestudy.dto.CustomerDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IServiceService service;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("list")
    public ModelAndView getAllCustomer(@RequestParam(value = "search", defaultValue = "") String search,
                                       @PageableDefault(value = 5) Pageable pageable,
                                       Model model) {
        model.addAttribute("search", search);
        return new ModelAndView("contract/list", "contracts", contractService.showAllContract(pageable, search));
    }

    @GetMapping("formAddNew")
    public String getFormAdd(Model model) {
        model.addAttribute("services", service.findServiceByDto());
        model.addAttribute("customers", customerService.findCustomerByDto());
        model.addAttribute("employees", employeeService.findEmployeeByDto());
        model.addAttribute("contractDto", new ContractDto());
        return "contract/add";
    }


    @PostMapping("addNew")
    public String saveNewContract(@ModelAttribute ContractDto contractDto,
                                  RedirectAttributes attributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.addNewContract(contract);
        attributes.addFlashAttribute("add", "Added new contract successfully!");
        return "redirect:/contract/formAddNew";
    }
}
