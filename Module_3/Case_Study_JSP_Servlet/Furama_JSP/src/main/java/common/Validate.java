package common;

import java.util.regex.Pattern;

public class Validate {
    public static final String CUSTOMER_ID = "^KH-[\\d]{4}$";
    public static boolean validateCustomerId(String id) {
        return Pattern.matches(CUSTOMER_ID,id);
    }
}
