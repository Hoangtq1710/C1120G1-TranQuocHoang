package session_01.practice;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("LinearEquationResolver (ax + b = 0)");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a :");
        double a = scanner.nextDouble();

        System.out.println("Enter b :");
        double b = scanner.nextDouble();

        if (a != 0) {
            double result = (-b/a);
            System.out.println("X = "+result);
        } else if (b != 0) {
            System.out.println("No Solution");
        } else {
            System.out.println("Wealth of counter");
        }
    }
}
