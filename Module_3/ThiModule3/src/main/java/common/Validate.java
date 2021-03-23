package common;

import model.Customer;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Pattern;

public class Validate {

    static CustomerService customerService = new CustomerServiceImpl();

    public static final String CUSTOMER_ID = "^KH-[\\d]{4}$";
    public static final String CUSTOMER_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
    public static final String CUSTOMER_PHONE = "^(090|091|(\\+84)090|(\\+84)091)[\\d]{7}$";
    public static final String CUSTOMER_ID_CARD = "^[\\d]{9}|[\\d]{12}$";
    public static final String CUSTOMER_EMAIL = "^[\\w!#$%&’*+=?`{|}~^-]+(?:\\.[\\w!#$%&’*+=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public static String validateCustomerId(String id) {
        String message = null;

        if (!CUSTOMER_ID.matches(id)) {
            message = "INVALID CUSTOMER ID";
        } else {
            List<Customer> listCustomer = customerService.findAllCustomer();
            for (Customer customer : listCustomer) {
                if (id.equals(customer.getCustomerId())) {
                    return "CUSTOMER ID EXIST";
                }
            }
        }
        return message;
    }

    public static String validateCustomerName(String name) {
        String message = null;
        if (!CUSTOMER_NAME.matches(name)) {
            message = "INVALID CUSTOMER NAME";
        }
        return message;
    }

    public static String validateCustomerPhone(String phone) {
        String message = null;
        if (!CUSTOMER_PHONE.matches(phone)) {
            message = "INVALID CUSTOMER PHONE";
        }
        return message;
    }

    public static String validateCustomerIdCard(String idCard) {
        String message = null;
        if (!CUSTOMER_ID_CARD.matches(idCard)) {
            message = "INVALID CUSTOMER ID CARD";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;
        if (!CUSTOMER_EMAIL.matches(email)) {
            message = "INVALID CUSTOMER EMAIL";
        }
        return message;

    }

//    public static String validateBirthday(String birthday) {
//        Pattern DATE_PATTERN = Pattern.compile(
//                "^(29/02/(2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26]))))$" +
//                        "|^((0[1-9]|1[0-9]|2[0-8])/02/((19|2[0-9])[0-9]{2}))$" +
//                        "|^((0[1-9]|[12][0-9]|3[01])/(0[13578]|10|12)/((19|2[0-9])[0-9]{2}))$" +
//                        "|^((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|2[0-9])[0-9]{2}))$");
//        String message = null;
//        if (!DATE_PATTERN.matcher(birthday).matches()) {
//            return "Invalid Format";
//        }
//        String[] birthdayArray = birthday.split("/");
//        int year = Integer.parseInt(birthdayArray[2]);
//        int month = Integer.parseInt(birthdayArray[1]);
//        int day = Integer.parseInt(birthdayArray[0]);
//        LocalDate birthdate = LocalDate.of(year, month, day);
//        LocalDate now = LocalDate.now();
//        long age = Period.between(birthdate, now).getYears();
//        if (age < 18 || age > 125) {
//            return "18 <= Age <= 125";
//        }
//        return message;
//    }


}
