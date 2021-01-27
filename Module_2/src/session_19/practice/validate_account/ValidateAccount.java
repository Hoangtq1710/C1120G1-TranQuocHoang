package session_19.practice.validate_account;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String REGEX = "^[_a-z0-9]{6,}$";
    public static boolean validateAccount(String str) {
        return Pattern.matches(REGEX, str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name of Account : ");
        String nameAccount = scanner.nextLine();
        if (validateAccount(nameAccount)) {
            System.out.println("Name "+nameAccount+" is Valid");
        } else {
            System.out.println("Name "+nameAccount+" is NOT Valid");
        }
    }
}
