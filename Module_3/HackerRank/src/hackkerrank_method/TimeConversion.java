package hackkerrank_method;

public class TimeConversion {
    static String timeConversion(String s) {
        String str = "";
        if (s.contains("AM")) {
            if (Integer.parseInt(s.substring(0,2)) != 12) {
                str = s.substring(0,8);
            } else {
                str = "00"+s.substring(2,8);
            }

        } else {
            if (Integer.parseInt(s.substring(0,2)) == 12) {
                str = s.substring(0,8);
            } else {
                str += (12 + Integer.parseInt(s.substring(0,2))) + s.substring(2,8);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "12:08:06AM";
        String str2 = "12:45:54PM";
        System.out.println(timeConversion(str));
        System.out.println(timeConversion(str2));
    }
}
