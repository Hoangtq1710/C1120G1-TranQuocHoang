package hackkerrank_method;

public class TaumAndBday {
    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long bi = b;
        long wi = w;
        long bci = bc;
        long wci = wc;
        long zi = z;
        long case1 = (bi*bci+wi*wci);
        long case2 = wi*wci+bi*(zi+wci);
        long case3 = bi*bci+wi*(zi+bci);
        if ((case1 <= case2) && (case1 <= case3)) {
            return case1;
        } else if ((case2 <= case1) && (case2 <= case3)) {
            return case2;
        } else {
            return case3;
        }
    }

    public static void main(String[] args) {
        System.out.println(taumBday(31470,73137,999563,625186,287011));
    }
}
