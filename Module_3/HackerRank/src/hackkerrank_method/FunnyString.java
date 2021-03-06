package hackkerrank_method;

public class FunnyString {
    static String funnyString(String s) {
        String r = "";
        int l = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        int[] cArr = new int[l - 1];
        int[] rArr = new int[l - 1];

        for (int i = 0; i < l - 1; i++) {
            cArr[i] = Math.abs((int) (s.charAt(i)) - (int) (s.charAt(i +1)));
            rArr[i] = Math.abs((int) (r.charAt(i)) - (int) (r.charAt(i +1)));
        }
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != rArr[i]) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        String str = "acxz";
        String str2 = "bcxz";
        System.out.println(funnyString(str));
        System.out.println(funnyString(str2));
        //done
    }
}
