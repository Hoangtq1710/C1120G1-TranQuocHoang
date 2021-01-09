package ExtraExer;

import java.util.Scanner;

public class Ex07_FindingFibonacciN {
    public static Integer findingFiboN(int number){
        int a = 0;
        int b = 1;
        int c = 0;
        int count = 0;

        while (true){
            c = a + b;
            a = b;
            b = c;
            count++;
            if (count == number){
                return c;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Finding N of Fibonacci");
        Scanner scanner = new Scanner(System.in);
        int position;
        System.out.print("Enter a position in Fibonacci chain (position > 1): ");
        do {
            position = scanner.nextInt();
            if (position < 2) {
                System.out.println("Position must be greater than 2!");
            }
        } while (position < 2);
        System.out.println("Number in Fibonacci at position "+position+" is "+findingFiboN(position -1));
    }
}
