package extra_exercise.hackkerrank_method;

public class JumpingOnTheCloud {
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int n = c.length;
        int currentCloud = 0;
        do {
            currentCloud = (currentCloud + k) % n;
            energy--;
            if (c[currentCloud] == 1) {
                energy -= 2;
            }
        } while (currentCloud != 0);
        return energy;
    }

    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println(jumpingOnClouds(c,2));
    }
}
