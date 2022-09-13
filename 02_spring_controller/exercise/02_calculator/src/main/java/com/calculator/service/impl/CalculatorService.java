package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    public String calculator(String num1, String num2, String cal) {
        try {
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            switch (cal) {
                case "/":
                    if (number2 == 0) {
                        return "The second number must be different from number 0";
                    }
                    return String.valueOf(number1 / number2);
                case "-":
                    return String.valueOf(number1 - number2);
                case "x":
                    return String.valueOf(number1 * number2);
                default:
                    return String.valueOf(number1 + number2);
            }
        } catch (NumberFormatException e) {
            return "The first number and the second number must be a number";
        }
    }

}
