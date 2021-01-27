package session_19.exercise.validate_phone_number;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateAmericaPhone {
    //+12456321741 (1452)
    private static final String REGEX = "\\+[\\d]{11} \\([\\d]{4}\\)";
    public static boolean validateAmerica(String str) {
        return Pattern.matches(REGEX,str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phone number : ");
        String number = scanner.nextLine();
        if (validateAmerica(number)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
