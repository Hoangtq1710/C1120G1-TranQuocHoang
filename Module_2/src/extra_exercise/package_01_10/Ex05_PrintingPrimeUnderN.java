package extra_exercise.package_01_10;

import java.util.Scanner;
//in ra các số nguyên tố nhỏ hơn number
public class Ex05_PrintingPrimeUnderN {
    public static void printPrime(int number){
        System.out.print("Prime under "+number+" : ");
        for (int i = 2; i < number; i++) {
            if (Ex04_FactorAnalysis.isPrime(i)) {
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(" Printing Prime Under");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter the number : ");
        number = scanner.nextInt();
        printPrime(number);
    }
}
