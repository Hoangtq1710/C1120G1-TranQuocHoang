package session_19.exercise.validate_phone_number;

import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String REGEX = "\\([\\d]{2}\\)-\\(0[\\d]{9}\\)";
    public static boolean validatePhone(String str) {
        return Pattern.matches(REGEX,str);
    }

    public static void main(String[] args) {
        String str = "(58)-(1222222222)";
        if (validatePhone(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
