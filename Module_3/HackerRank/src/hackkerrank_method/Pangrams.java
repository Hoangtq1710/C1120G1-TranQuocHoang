package hackkerrank_method;

public class Pangrams {
    //A String is a pangrams if All of the letters of the alphabet are present in that String.
    //ascii of a to z is between 97 and 122
    static String pangrams(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            }
        }
        int[] check = new int[26];
        int start = 97;
        for (int i = 0; i < str.length(); i++) {
            int code  = ((int) str.charAt(i)) - start;
            check[code] = 1;
        }
        for(int ele : check) {
            if (ele != 1) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    public static void main(String[] args) {
        String str = "We promptly judged antique ivory buckles for the next prize";
        String str2 = "We promptly judged antique ivory buckles for the prize";

        System.out.println(pangrams(str));
        System.out.println(pangrams(str2));
    }
}
