package extra_exercise.hackkerrank;

public class NumberLineJumps {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 > v2) {
            int remainder = (x1 - x2) % (v1 - v2);
            if (remainder == 0) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));
    }
}
