package session_02.practice;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        System.out.println("Bank Interest");
        double money;
        int month;
        double rate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the money : ");
        money = scanner.nextDouble();
        System.out.println("Enter month : ");
        month = scanner.nextInt();
        System.out.println("Enter the rate per year");
        rate = scanner.nextDouble();
        double interest = 0;
        for (int i = 0; i < month; i++) {
            interest += money * (rate/12/100);
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str = currencyVN.format(interest);
        System.out.println("Total interest is "+str+" VND");
    }
}
