package session_19.exercise.validate_class_name;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateClassName {
    private static final String REGEX = "[CAP][\\d]{4}[GHIKLM]";
    public static boolean validateClassName(String str) {
        return Pattern.matches(REGEX,str);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a class name : ");
        String className = scanner.nextLine();
        if (validateClassName(className)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
