package common;


public class Validate {


    public static String validateCustomerName(String name) {
        String message = null;
        if ((name.length() < 5 || name.length() > 50)) {
            message = "INVALID CUSTOMER NAME";
        }
        return message;
    }

    public static String validateCustomerPhone(String phone) {
        String message = null;
        String regex = "^[\\d]+$";
        if (!phone.matches(regex) || (phone.length() > 10)) {
            message = "INVALID CUSTOMER PHONE";
        }
        return message;
    }

    public static String validateDescription(String description) {
        String message = null;
        if ((description.length() > 10)) {
            message = "DESCRIPTION TOO LONG";
        }
        return message;

    }
}
