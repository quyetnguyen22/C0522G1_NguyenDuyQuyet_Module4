package com.example.phone.controller;

import com.example.phone.model.Phone;
import com.example.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("phone")
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @PostMapping
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Phone>> getAllPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable int id) {
        return new ModelAndView("list","phones",  phoneService.findById(id).get());
    }
    @PatchMapping("/saveEditing")
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.save(phone),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable int id) {
        Optional<Phone> phoneOptional = phoneService.findById(id);
        if (phoneOptional.isPresent()) {
            phoneService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}