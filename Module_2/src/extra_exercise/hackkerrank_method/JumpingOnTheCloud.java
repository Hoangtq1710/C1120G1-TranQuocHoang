package extra_exercise.hackkerrank;

public class JumpingOnTheCloud {
    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int circle = 0;
        int i = 0;
        while (true) {
            for (; i < c.length; i += k) {
                e -= 1;
                int check;
                if (i + k >= c.length) {
                    i = (i + k) - c.length;
                    circle++;
                    break;
                }
                check = (c[i+k] == 0) ? 1 : 2;
                e -= check;
            }
            if (circle != 0 && i == 0) {
                return e;
            }
        }
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println(jumpingOnClouds(c,2));
    }
}
