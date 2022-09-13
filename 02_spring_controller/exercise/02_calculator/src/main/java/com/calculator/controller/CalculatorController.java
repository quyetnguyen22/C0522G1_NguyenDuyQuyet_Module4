package com.calculator.controller;

import com.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/input")
    public String input() {
        return "calculator";
    }

    @GetMapping("/calculator")
    public ModelAndView calculator(@RequestParam(value = "num1", defaultValue = "0") String num1,
                                   @RequestParam(value = "num2", defaultValue = "0") String num2,
                                   @RequestParam(value = "cal", defaultValue = "") String cal) {
        return new ModelAndView("calculator", "result", calculatorService.calculator(num1, num2, cal));
    }
}
