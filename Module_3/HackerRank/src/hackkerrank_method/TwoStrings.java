package hackkerrank_method;

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        if (s1.length() > s2.length()) {
            for (int i = 0; i < s2.length(); i++) {
                if (s2.contains((s1.charAt(i)+""))) {
                    return "YES";
                }
            }
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s2.contains((s1.charAt(i)+""))) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = "world";
        System.out.println(twoStrings(s1,s2));
        //not done yet 02:28 AM 07/03/21
    }
}
