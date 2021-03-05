package extra_exercise.hackkerrank_method;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        int[] emptyArr = new int[n];
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                emptyArr[j] += queries[i][2];
            }
        }
        int max = 0;
        for (int i = 0; i < emptyArr.length; i++) {
            if (emptyArr[i] >= max) {
                max = emptyArr[i];
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
