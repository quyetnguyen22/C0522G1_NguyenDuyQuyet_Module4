package com.casestudy.controller;

import com.casestudy.dto.EmployeeDto;
import com.casestudy.model.employee.Employee;
import com.casestudy.service.employee.IEmployeeDepartmentService;
import com.casestudy.service.employee.IEmployeeEduLevelService;
import com.casestudy.service.employee.IEmployeePositionService;
import com.casestudy.service.employee.IEmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEmployeeDepartmentService departmentService;

    @Autowired
    private IEmployeeEduLevelService eduLevelService;

    @Autowired
    private IEmployeePositionService positionService;

    @GetMapping("list")
    public ModelAndView getAllEmployee(@PageableDefault(size = 5) Pageable pageable,
                                       @RequestParam(value = "search", defaultValue = "") String search,
                                       Model model) {
        model.addAttribute("departments", departmentService.getEmployeeDepartment());
        model.addAttribute("eduLevels", eduLevelService.getEmployeeEduLevel());
        model.addAttribute("positions", positionService.getEmployeePosition());
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("search", search);
        return new ModelAndView("employee/list", "allEmployee", employeeService.showAllEmployee(pageable, search));
    }

    @GetMapping("formAddNew")
    public String getFormAdd(Model model) {
        model.addAttribute("departments", departmentService.getEmployeeDepartment());
        model.addAttribute("eduLevels", eduLevelService.getEmployeeEduLevel());
        model.addAttribute("positions", positionService.getEmployeePosition());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/add";
    }

    @PostMapping("addNew")
    public String saveNewCustomer(@ModelAttribute EmployeeDto employeeDto,
                                  RedirectAttributes attributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.addNewEmployee(employee);
        attributes.addFlashAttribute("add", "Added " + employee.getName() + " successfully!");
        return "redirect:/employee/formAddNew";
    }

    @GetMapping("formEdit/{id}")
    public String getFormEdit(@PathVariable int id,
                              @PageableDefault(size = 5) Pageable pageable,
                              @RequestParam(value = "search", defaultValue = "") String search,
                              Model model) {
        Employee employee = employeeService.searchById(id).get();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("departments", departmentService.getEmployeeDepartment());
        model.addAttribute("eduLevels", eduLevelService.getEmployeeEduLevel());
        model.addAttribute("positions", positionService.getEmployeePosition());
        model.addAttribute("allEmployee", employeeService.showAllEmployee(pageable, search));
        model.addAttribute("msg", "edit");

        return "employee/list";
    }

    @PostMapping("edit")
    public String saveEditing(@ModelAttribute EmployeeDto employeeDto,
                              RedirectAttributes attributes) {
        Employee employee = employeeService.searchById(employeeDto.getId()).get();

        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.editEmployee(employee);
        attributes.addFlashAttribute("edit", "Edited " + employee.getName() + " successfully");
        return "redirect:/employee/list";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id,
                                 RedirectAttributes attributes) {
        Optional<Employee> employee = employeeService.searchById(id);
        if (employee.isPresent()) {
            attributes.addFlashAttribute("del", "Deleted " + employee.get().getName() + " successfully.");
            employeeService.deleteEmployee(id);
        }
        return "redirect:/employee/list";
    }
}
