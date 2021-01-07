package session_01.practice;

import java.util.Scanner;

public class CheckingLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            int year;
            System.out.println("Enter a year");
            year = scanner.nextInt();
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        System.out.println(year+" is a Leap year");
                    } else {
                        System.out.println(year+" is not a Leap year");
                    }
                } else {
                    System.out.println(year+" is a Leap year");
                }
            } else {
                System.out.println(year+" is not a Leap year");
            }
        }
    }
}
