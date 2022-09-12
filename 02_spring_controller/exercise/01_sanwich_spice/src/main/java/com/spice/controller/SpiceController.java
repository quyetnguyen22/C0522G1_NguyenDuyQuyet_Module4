package com.spice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpiceController {
    @GetMapping("/menu")
    public String menu() {
        return "sandwich";
    }

    @GetMapping("/choose")
    public ModelAndView sandwich(@RequestParam(value = "condiments", defaultValue = "") String[] arr) {
        if (arr.length == 0) {
           return new ModelAndView("order","condiments", "Empty!");
        } else {
            return new ModelAndView("order","condiments", arr);
        }
    }
}
