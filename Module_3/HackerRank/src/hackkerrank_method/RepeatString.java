package extra_exercise.hackkerrank_method;

public class RepeatString {
    static long repeatedString(String s, long n) {

        long len = s.length();
        long times = n / len;
        long left = n % len;
        long count = 0;
        long countA = 0;
        String result;
        if (left > 0) {
            result = s.substring(0, (int) (left + 1));
            for (int i = 0; i < result.length(); i++) {
                if (s.charAt(i) == 'a') {
                    countA++;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return (long)(count*times + countA);
    }

    public static void main(String[] args) {
        String str = "babbaabbabaababaaabbbbbbbababbbabbbababaabbbbaaaaabbaababaaabaabbabababaabaabbbababaabbabbbababbaabb";
        System.out.println(repeatedString(str, 395886361));
    }
}
