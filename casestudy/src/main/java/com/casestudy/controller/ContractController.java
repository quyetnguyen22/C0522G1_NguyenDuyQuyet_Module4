package com.casestudy.controller;

import com.casestudy.dto.ContractDetailDto;
import com.casestudy.dto.ContractDto;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.service.ServiceAttach;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import com.casestudy.service.customer.ICustomerService;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.service.IServiceAttachService;
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

    @Autowired
    private IServiceAttachService attachService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("list")
    public ModelAndView getAllContrac(@RequestParam(value = "search", defaultValue = "") String search,
                                       @PageableDefault(value = 5) Pageable pageable,
                                       Model model) {
        model.addAttribute("search", search);
        model.addAttribute("ServiceAttach", attachService.getListServiceAttach());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
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

    @PostMapping("addContractDetail")
    public String saveNewService(@ModelAttribute ContractDetailDto contractDetailDto,
                                  RedirectAttributes attributes) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.addNewContractDetail(contractDetail);
        attributes.addFlashAttribute("add", "Added new contract detail successfully!");
        return "redirect:/contract/list";
    }

}
