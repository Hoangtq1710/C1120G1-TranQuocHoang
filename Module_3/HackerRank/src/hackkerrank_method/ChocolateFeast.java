package hackkerrank_method;

public class ChocolateFeast {
    static int chocolateFeast(int n, int c, int m) {
        int max = 0;
        max += n / c;
        int buy = max;
        while (buy >= m) {
            int i = buy / m;
            int t = buy % m;
            max += i;
            buy = i + t;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(chocolateFeast(15,3,2));
        System.out.println(chocolateFeast(10,2,5));
        System.out.println(chocolateFeast(12,4,4));
        System.out.println(chocolateFeast(6,2,2));
        //done
    }
}
