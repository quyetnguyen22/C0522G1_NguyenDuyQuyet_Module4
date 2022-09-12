package com.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping("/input")
    public String input() {
        return "calculator";
    }

    @GetMapping("/calculator")
    public ModelAndView (@RequestParam(value = "cal", defaultValue = "0") Double number) {
        return new ModelAndView("caculator", "result", )
    }
}
