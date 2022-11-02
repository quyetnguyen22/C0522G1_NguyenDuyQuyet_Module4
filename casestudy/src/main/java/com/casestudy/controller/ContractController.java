//package com.casestudy.controller;
//
//import com.casestudy.dto.ContractDetailDto;
//import com.casestudy.dto.IContractDto;
//import com.casestudy.model.contract.ContractDetail;
//import com.casestudy.service.contract.IContractDetailService;
//import com.casestudy.service.contract.IContractService;
//import com.casestudy.service.customer.ICustomerService;
//import com.casestudy.service.employee.IEmployeeService;
//import com.casestudy.service.service.IServiceAttachService;
//import com.casestudy.service.service.IServiceService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.time.LocalDate;
//import java.util.List;
//
//
//@Controller
//@RequestMapping("contract")
//public class ContractController {
//
//    @Autowired
//    private IContractService contractService;
//
//    @Autowired
//    private IServiceService iServiceService;
//
//    @Autowired
//    private ICustomerService customerService;
//
//    @Autowired
//    private IEmployeeService employeeService;
//
//    @Autowired
//    private IServiceAttachService attachService;
//
//    @Autowired
//    private IContractDetailService contractDetailService;
//
//    @GetMapping("list")
//    public ModelAndView getAllContract(@RequestParam(value = "search", defaultValue = "") String search,
//                                       @PageableDefault(value = 5) Pageable pageable,
//                                       Model model) {
//        model.addAttribute("search", search);
//        LocalDate beginDate = LocalDate.now();
//        model.addAttribute("beginDate", beginDate);
//        model.addAttribute("services", iServiceService.findService());
//        model.addAttribute("customers", customerService.findCustomer());
//        model.addAttribute("employees", employeeService.findEmployee());
//        model.addAttribute("ServiceAttach", attachService.getListServiceAttach());
//        model.addAttribute("contractDetailDto", new ContractDetailDto());
//        Page<IContractDto> contract = contractService.showAllContract(pageable, search);
//        return new ModelAndView("contract/list", "contracts", contract);
//    }
//
//    @PostMapping("addContractDetail")
//    public String saveNewService(@ModelAttribute ContractDetailDto contractDetailDto,
//                                  RedirectAttributes attributes) {
//        ContractDetail contractDetail = new ContractDetail();
//        BeanUtils.copyProperties(contractDetailDto, contractDetail);
//        contractDetailService.addNewContractDetail(contractDetail);
//        attributes.addFlashAttribute("add", "Added new contract detail successfully!");
//        return "redirect:/contract/list";
//    }
//
//}
