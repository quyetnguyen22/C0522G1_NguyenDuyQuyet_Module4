package com.casestudy.rest_controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerRank;
import com.casestudy.service.customer.ICustomerRankService;
import com.casestudy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerRankService rankService;

//    @GetMapping("/list")
//    public ResponseEntity<Page<Customer>> getCustomerList(@PageableDefault Pageable pageable) {
//
//        Page<Customer> customerList = customerService.showAllCustomer(pageable);
//
//        if (customerList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(customerList, HttpStatus.OK);
//        }
//    }

    @GetMapping("/rank")
    public ResponseEntity<List<CustomerRank>> getRankList() {
        List<CustomerRank> customerRanks = rankService.showAllCustomerRank();

        if (customerRanks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerRanks, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id) {

        Customer customer = customerService.findById(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> saveAdding(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.addNewCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Customer> saveEditing(@RequestBody CustomerDto customerDto,
                                                @PathVariable int id) {
        Customer customer = customerService.findById(id).get();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.editCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.deleteCustomer(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getCustomer(@RequestParam(value = "name", defaultValue = "") String name,
                                                       @PageableDefault Pageable pageable) {
        Page<Customer> customerList = customerService.getCustomer(pageable, name);

        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
    }
}
