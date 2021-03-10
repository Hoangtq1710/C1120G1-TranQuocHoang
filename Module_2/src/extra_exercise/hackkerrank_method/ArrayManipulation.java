package extra_exercise.hackkerrank_method;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        int[] emptyArr = new int[n];
        for (int[] query : queries) {
            for (int j = query[0]; j <= query[1]; j++) {
                emptyArr[j] += query[2];
            }
        }
        int max = 0;
        for (int value : emptyArr) {
            if (value >= max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] arr = {{1,2,100},{2,5,100},{3,4,100}};
        System.out.println(arrayManipulation(n,arr));
    }
}
