package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.dto.ServiceDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.Services;
import com.casestudy.service.employee.IEmployeeService;
import com.casestudy.service.service.IServiceRentingService;
import com.casestudy.service.service.IServiceService;
import com.casestudy.service.service.IServiceTypeService;
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
@RequestMapping("facility")
public class ServiceController {

    @Autowired
    private IServiceService services;

    @Autowired
    private IServiceTypeService typeService;

    @Autowired
    private IServiceRentingService rentingService;

    @GetMapping("list")
    public ModelAndView getAllService(@RequestParam(value = "search", defaultValue = "") String search,
                                      @PageableDefault(value = 5) Pageable pageable,
                                       Model model) {
        model.addAttribute("search", search);
        return new ModelAndView("service/list", "allService", services.showAllService(pageable, search));
    }

//    @GetMapping("info/{id}")
//    public String getInfo(@PathVariable() int id,
//                          @PageableDefault(value = 5) Pageable pageable,
//                          @RequestParam(value = "search", defaultValue = "") String search,
//                          Model model) {
//        model.addAttribute("search", search);
//        model.addAttribute("allCustomer", customerService.showAllCustomer(pageable, search));
//        model.addAttribute("customer",customerService.findById(id).get());
//        return "/customer/list";
//    }

    @GetMapping("formAddNew")
    public String getFormAdd(Model model) {
        model.addAttribute("rentingType", rentingService.showAllServiceRenting());
        model.addAttribute("serviceTypes", typeService.showAllServiceType());
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/add";
    }


    @PostMapping("addNew")
    public String saveNewFacility(@ModelAttribute ServiceDto serviceDto,
                                  RedirectAttributes attributes) {
        Services service = new Services();
        BeanUtils.copyProperties(serviceDto, service);
        services.addNewService(service);
        attributes.addFlashAttribute("add", "Added " + service.getName() + " successfully!");
        return "redirect:/facility/formAddNew";
    }

    @GetMapping("formEdit/{id}")
    public String getFormEdit(@PathVariable int id,
                              Model model) {
        Services service = services.searchById(id).get();
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        model.addAttribute("rentingType", rentingService.showAllServiceRenting());
        model.addAttribute("serviceTypes", typeService.showAllServiceType());

        return "service/edit";
    }

    @PostMapping("edit")
    public String saveEditing(@ModelAttribute ServiceDto serviceDto,
                              RedirectAttributes attributes) {
        Services service = services.searchById(serviceDto.getId()).get();

        BeanUtils.copyProperties(serviceDto, service);
        services.editService(service);
        attributes.addFlashAttribute("edit", "Edited " + service.getName() + " successfully");
        return "redirect:/facility/list";
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(@PathVariable int id,
                                 RedirectAttributes attributes) {
        Optional<Services> service = services.searchById(id);
        if (service.isPresent()) {
            attributes.addFlashAttribute("del", "Deleted " + service.get().getName() + " successfully.");
            services.deleteService(id);
        }
        return "redirect:/facility/list";
    }
}
