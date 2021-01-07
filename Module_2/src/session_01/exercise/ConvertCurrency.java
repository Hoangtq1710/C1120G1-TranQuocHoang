package session_01.exercise;

import java.util.Scanner;

public class ConvertCurrency {
    public static void main(String[] args) {
        System.out.println("Convert Currency");
        Scanner scanner = new Scanner(System.in);

        System.out.println("From Currency : \n" +
                "1. VND\n" +
                "2. USD\n" +
                "3. EUR\n");
        int from = scanner.nextInt();
        System.out.println("To Currency : \n" +
                "1. VND\n" +
                "2. USD\n" +
                "3. EUR\n");
        int to = scanner.nextInt();
        System.out.println("Input Amount : ");

        double amount = scanner.nextDouble();
        double result = amount * Switch(from) / Switch(to);
        System.out.println("OUTPUT : "+Math.floor(result*100)/100); // làm tròn về 2 chữ số thập phân.
    }

    public static Integer Switch(int input) {
        int out = 0;
        boolean flag = true;
        do {
            switch (input) {
                case 1:
                    out = 1;
                    break;
                case 2:
                    out = 23000;
                    break;
                case 3:
                    out = 25000;
                    break;
                default:
                    System.out.println("Select option in menu!");
                    flag = false;
                    break;
            }
        } while (!flag);
        return out;
    }
}
