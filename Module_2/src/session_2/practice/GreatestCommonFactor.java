package session_2.practice;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a;
        int b;
        System.out.println("Greatest Common Factor");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number a : ");
        a = Math.abs(scanner.nextInt());
        int c = a;
        System.out.println("Enter number b");
        b = Math.abs(scanner.nextInt());
        int d = b;

        if ((a == 0) || (b == 0)) {
            System.out.println("No greatest common factor");
        } else {
            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            System.out.println("Greatest common factor of "+c+" and "+d+" is "+a);
        }
    }
}
