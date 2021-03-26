package common;

public class Validate {
    public static final String CUSTOMER_ID = "^KH-[\\d]{4}$";
    public static final String CUSTOMER_NAME = "^[\\w]$";
    public static String validateCustomerId(String id) {
        String message = null;
        if (!CUSTOMER_ID.matches(id)) {
            message = "Invalid CUSTOMER ID";
        }
        return message;
    }
    public static String validateCustomerName(String name) {
        String message = null;
        if (!CUSTOMER_NAME.matches(name)) {
            message = "Invalid CUSTOMER NAME";
        }
        return message;
    }
}
