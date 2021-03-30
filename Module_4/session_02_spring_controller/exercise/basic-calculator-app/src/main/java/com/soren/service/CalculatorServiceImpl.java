package com.soren.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public double calculate(String first, String second, String operator) {
        double result = 0;
        double firstNumber = Double.parseDouble(first);
        double secondNumber = Double.parseDouble(second);
        switch (operator){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0){
                    result = firstNumber / secondNumber;
                } else {
                    throw new ArithmeticException();
                }
                break;
        }
        return result;
    }
}
