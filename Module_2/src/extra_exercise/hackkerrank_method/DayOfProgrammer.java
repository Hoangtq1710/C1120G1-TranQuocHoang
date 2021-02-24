package extra_exercise.hackkerrank;

public class DayOfProgrammer {
    static String dayOfProgrammer(int year) {
        if (year == 1918) {
            return "26.09.1918";
        }
        String a = "13.09.";
        String b = "12.09.";

        if (checkingLeapYear(year)) {
            return b + year;
        } else {
            return a + year;
        }

    }
    static boolean checkingLeapYear(int year) {
        if (year < 1918) {
            return year % 4 == 0;
        } else {
            return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
        }
    }

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1700));
        System.out.println(checkingLeapYear(1700));
    }
}
