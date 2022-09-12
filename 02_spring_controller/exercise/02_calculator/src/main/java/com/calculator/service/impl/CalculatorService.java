package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    public double calculator(double num1, double num2, String cal) {
        switch (cal) {
            case "/":
                return num1 / num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            default:
                return num1 + num2;
        }
    }
}
