package session_2.exercise;

import java.util.Scanner;

public class First20Prime {
    public static void main(String[] args) {
        System.out.println("First 20 Prime");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int number;
        int count = 0;
        int start = 1;
        do {
            number = scanner.nextInt();
        } while (number < 1);
        while (count < number) {
            if (isPrime(start)) {
                System.out.print(start+" ");
                count++;
            }
            start += 1;
        }
    }

    public static Boolean isPrime(int number){
        int countPrime = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                countPrime++;
            }
        }
        return countPrime == 2;
    }
}
