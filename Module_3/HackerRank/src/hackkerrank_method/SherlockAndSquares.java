package hackkerrank_method;

public class SherlockAndSquares {
    static int squares(int a, int b) {
        int count = 0;
        for (int i = 1; i <= (int) Math.sqrt(b); i++) {
            if (Math.pow(i,2) >= a && Math.pow(i,2) <= b) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(squares(3,9));
        System.out.println(squares(17, 24));
        System.out.println(squares(17, 724));
    }
}
