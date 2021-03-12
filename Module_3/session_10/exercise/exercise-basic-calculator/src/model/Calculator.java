package model;

public class Calculator {
    public static float calculate(float first, float second, char operator) {
        switch (operator) {
            case '+' :
                return (first + second);
            case '-':
                return (first - second);
            case '*':
                return (first * second);
            case '/':
                if (second != 0) {
                    return (first / second);
                } else {
                    throw new RuntimeException("Can't divine by zero");
                }
            default:
                throw new RuntimeException("Invalid Operator");
        }
    }
}
