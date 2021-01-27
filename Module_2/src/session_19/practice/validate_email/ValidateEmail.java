package session_19.practice.validate_email;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static boolean validateEmail(String str) {
        return Pattern.matches(REGEX,str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Email : ");
        String str = scanner.nextLine();
        if (validateEmail(str)) {
            System.out.println("Email "+str+" is valid!");
        } else {
            System.out.println("Email "+str+" is NOT valid!");
        }
    }
}
