package extra_exercise.package_21_30;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;

import java.util.Scanner;

public class Ex22_DisplayDivisor {
    public static void displayDivisor(int number) {
        int count = 0;
        System.out.print("a) All Divisor of "+number+" is ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i+" ");
                count++;
            }
        }
        String c = "";
        if (count > 1) {
            c = "s";
        }
        System.out.println("\n"+number+" have "+count+" divisor"+c);
    }
    public static void displayPrimeDivisor(int number) {
        int count = 0;
        System.out.print("b) All Prime Divisor of "+number+" is ");
        for (int i = 2; i <= number; i++) {
            if (number % i == 0 && (Ex04_FactorAnalysis.isPrime(i))) {
                System.out.print(i+" ");
                count++;
            }
        }

        String c = "";
        if (count > 1) {
            c = "s";
        }
        System.out.println("\n"+number+" have "+count+" prime divisor"+c+"\n");
    }

    public static void main(String[] args) {
        System.out.println("Display Divisor of a Number");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a number : ");
        do {
            number = scanner.nextInt();
            if (number < 2) {
                System.out.println("Number must be greater than 1");
            }
        } while (number < 2);
        displayDivisor(number);
        displayPrimeDivisor(number);
    }
}
