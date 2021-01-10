package extra_exercise.package_21_30;

import extra_exercise.package_01_10.Ex04_FactorAnalysis;
import extra_exercise.package_11_20.Ex20_DisplayPrimeFiboUnderN;

import java.util.Scanner;

public class Ex23_DisplayFirstNPrimeFibo {
    public static void main(String[] args) {
        System.out.println("Exercise 23");
        Scanner scanner = new Scanner(System.in);
        int number;
        int countPrime = 0;
        int countFibo = 0;
        do {
            System.out.print("Enter a number : ");
            number = scanner.nextInt();
            if (number < 2) {
                System.out.println("Number must to greater than 1");
            }
        } while (number < 2);
        System.out.println("All Prime under "+number+" is ");
        for (int i = 2; i < number; i++) {
            if (Ex04_FactorAnalysis.isPrime(i)) {
                countPrime++;
                System.out.print(i+" ");
            }
            if (countPrime == 20) {
                System.out.print("\n");
                countPrime = 0;
            }
        }
        System.out.print("\nAll fibonacci under "+number+" is \n0 1 ");
        for (int i = 1; i < number; i++) {
            if (Ex20_DisplayPrimeFiboUnderN.isFibonacci(i)) {
                countFibo++;
                System.out.print(i+" ");
            }
            if (countFibo == 40) {
                System.out.print("\n");
                countFibo = 0;
            }
        }
    }
}
