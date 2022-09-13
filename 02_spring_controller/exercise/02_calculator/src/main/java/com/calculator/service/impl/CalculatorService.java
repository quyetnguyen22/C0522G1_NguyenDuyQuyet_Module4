package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    public String calculator(double num1, double num2, String cal) {

        switch (cal) {
            case "/":
                if (num2 == 0) {
                    return "The second number must be different from number 0";
                }
                return String.valueOf(num1 / num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "x":
                return String.valueOf(num1 * num2);
            default:
                return String.valueOf(num1 + num2);
        }
    }
}
