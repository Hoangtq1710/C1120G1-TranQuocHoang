package hackkerrank_method;

public class ApplesAndOranges {
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int countApple = 0;
        int countOrange = 0;

        for(int apple : apples) {
            if ((a + apple >= s) && (a + apple <= t)) {
                countApple++;
            }
        }
        for(int orange : oranges) {
            if ((b + orange >= s) && (b + orange <= t)) {
                countOrange++;
            }
        }
        System.out.println(countApple);
        System.out.println(countOrange);
    }

    public static void main(String[] args) {
        int[] apples = {-2,2,1};
        int[] orange = {5,-6};
        countApplesAndOranges(7,11,5,15,apples,orange);
    }
}
