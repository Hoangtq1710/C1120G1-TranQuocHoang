package extra_exercise.hackkerrank_method;

import java.math.BigInteger;

public class ExtraLongFactorials {
    static void extraLongFactorials(int n) {
         if (n <= 20) {
            int i = 1;
            long fact = 1;
            while (i <= n) {
                fact *= i;
                i++;
            }
            System.out.println(fact);
        } else {
            BigInteger fact = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact);
        }
    }

    public static void main(String[] args) {
        extraLongFactorials(10);
        extraLongFactorials(18);
        extraLongFactorials(26);
    }
}
