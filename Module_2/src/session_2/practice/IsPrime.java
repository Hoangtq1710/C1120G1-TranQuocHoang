package session_2.practice;

import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println("Checking Prime");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number+" is not a Prime");
        } else {
            int count  = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(number+" is a Prime");
            } else {
                System.out.println(number+" is not a Prime");
            }
        }
    }
}
