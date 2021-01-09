package extra_exercise.package_11_20;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;

import java.util.Scanner;

public class Ex20_DisplayPrimeFiboUnderN {
    public static boolean isFibonacci(int number) {
        int a = 0;
        int b = 1;
        int c = 0;
        while (c <= number) {
            c = a + b;
            a = b;
            b = c;
            if (c == number) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Display All Number is Prime and Fibonacci Under a Number");
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter a number (N > 1): ");
            number = scanner.nextInt();
            if (number < 2) {
                System.out.println("Number must be greater than 1");
            }
        } while (number < 2);
        System.out.print("All number match is : ");
        for (int i = 2; i < number; i++) {
            if ((Ex04_FactorAnalysis.isPrime(i)) && (isFibonacci(i))){
                System.out.print(i+" ");
            }
        }
    }
}
