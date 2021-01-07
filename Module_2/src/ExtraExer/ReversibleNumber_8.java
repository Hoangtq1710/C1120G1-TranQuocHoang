package ExtraExer;

import java.util.Scanner;

public class ReversibleNumber_8 {
    public static boolean checkReversible(int number){
        String str = Integer.toString(number);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() -1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Checking Reversible Number");
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Enter a number to check : ");
        do {
            number = scanner.nextInt();
            if (number < 1) {
                System.out.println("Number must be positive!");
            }
        } while (number < 1);
        if (checkReversible(number)) {
            System.out.println(number+" is a reversible number!");
        } else {
            System.out.println(number+" is NOT a reversible number!");
        }
    }
}
