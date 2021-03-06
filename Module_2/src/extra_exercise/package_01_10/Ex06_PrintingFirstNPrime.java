package extra_exercise.package_01_10;

import java.util.Scanner;

//in ra N số nguyên tố đầu tiên
public class Ex06_PrintingFirstNPrime {
    public static void printingFirstNPrime(int number){
        int count = 0;
        int i  = 2;
        while (count < number){
            if (Ex04_FactorAnalysis.isPrime(i)){
                System.out.print(" "+i);
                count++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Printing First N Prime");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a number : ");
        do {
            number = scanner.nextInt();
            if (number < 2) {
                System.out.println("N must be great than 2");
            }
        } while (number < 2);
        printingFirstNPrime(number);
    }
}
