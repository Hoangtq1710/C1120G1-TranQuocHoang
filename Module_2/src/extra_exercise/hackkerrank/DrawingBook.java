package extra_exercise.hackkerrank;

public class DrawingBook {
    static int pageCount(int n, int p) {
        if (n == 2 && p == 1) {
            return 0;
        }
        if ((n - p) == 1 && (n % 2 == 0)) {
            return (n - p + 1) / 2;
        } else {
            if (p <= (n / 2)) {
                return p /2;
            } else {
                return (n - p) / 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pageCount(8, 7));
        System.out.println(pageCount(6, 5));
        System.out.println(pageCount(2, 1));
    }
}
