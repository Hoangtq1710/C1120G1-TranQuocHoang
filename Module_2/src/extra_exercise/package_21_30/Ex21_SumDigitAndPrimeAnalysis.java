package extra_exercise.package_21_30;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;
import extra_exercise.package_11_20.Ex19_SumDigitPrime;

import java.util.Scanner;

public class Ex21_SumDigitAndPrimeAnalysis {
    public static void main(String[] args) {
        System.out.println("Counting Sum of Digits and Prime Analysis of a Number");
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a number : ");
            number = scanner.nextInt();
            if (number < 2) {
                System.out.println("Number must to greater than 1");
            }
        } while (number < 2);
        System.out.println("\n"+"Summary digits of "+number+" is "+ Ex19_SumDigitPrime.sumDigitOfPrime(number));
        System.out.println("Prime Analysis of "+ Ex04_FactorAnalysis.factorAnalysis(number));
    }
}
