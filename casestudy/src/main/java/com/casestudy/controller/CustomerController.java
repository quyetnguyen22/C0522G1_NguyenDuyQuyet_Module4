package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.service.customer.ICustomerRankService;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerRankService rankService;

    @GetMapping("list")
    public ModelAndView getAllCustomer(@PageableDefault(size = 5) Pageable pageable,
                                       @RequestParam(value = "search", defaultValue = "") String search,
                                       Model model) {
        model.addAttribute("search", search);
        model.addAttribute("allRank", rankService.showAllCustomerRank());
        model.addAttribute("customerDto", new CustomerDto());
        return new ModelAndView("customer/list", "allCustomer", customerService.showAllCustomer(pageable, search));
    }

    @GetMapping("formAddNew")
    public String getFormAdd(Model model) {
        model.addAttribute("allRank", rankService.showAllCustomerRank());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/add";
    }


    @PostMapping("addNew")
    public String saveNewCustomer(@ModelAttribute CustomerDto customerDto,
                                  RedirectAttributes attributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.addNewCustomer(customer);
        attributes.addFlashAttribute("add", "Added " + customer.getName() + " successfully!");
        return "redirect:/customer/formAddNew";
    }

    @GetMapping("formEdit/{id}")
    public String getFormEdit(@PathVariable int id,
                              Model model) {
        model.addAttribute("allRank", rankService.showAllCustomerRank());
        model.addAttribute("allRank", rankService.showAllCustomerRank());
        model.addAttribute("customerDto", new CustomerDto());
        Customer customer = customerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);

        return "customer/edit";
    }

    @PostMapping("edit")
    public String saveEditing(@ModelAttribute CustomerDto customerDto,
                              RedirectAttributes attributes) {
        Customer customer = customerService.findById(customerDto.getId()).get();

        BeanUtils.copyProperties(customerDto, customer);
        customerService.editCustomer(customer);
        attributes.addFlashAttribute("edit", "Edited " + customer.getName() + " successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable int id,
                                 RedirectAttributes attributes) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            attributes.addFlashAttribute("del", "Deleted " + customer.get().getName() + " successfully.");
            customerService.deleteCustomer(id);
        }
        return "redirect:/customer/list";
    }
}
