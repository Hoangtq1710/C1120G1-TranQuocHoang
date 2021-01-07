package session_01.practice;

import java.util.Scanner;

public class CountingDayInMonth {
    public static void main(String[] args) {
        System.out.println("Counting Day in Month");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter month");
            int month = scanner.nextInt();
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("Month "+month+" has 31 days");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("Month "+month+" has 30 days");
                    break;
                case 2:
                    System.out.println("Month "+month+" has 28 or 29 days");
                    break;
                default:
                    System.out.println("Wrong Month");
                    break;
            }
        }
    }
}
