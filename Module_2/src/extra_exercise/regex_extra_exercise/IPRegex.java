package extra_exercise.regex_extra_exercise;

import java.util.regex.Pattern;

public class IPRegex {
    public static void main(String[] args) {
        String IP_REGEX = "^((0[\\d]{0,2}|1?[\\d]{0,2}|2([0-4][\\d]|5[0-5]))\\.){3}(0[\\d]{0,2}|1[\\d]{0,2}|2([0-4][\\d]|5[0-5]))$";
        String ip = "";
        System.out.println(Pattern.matches(IP_REGEX,ip));
    }
}
