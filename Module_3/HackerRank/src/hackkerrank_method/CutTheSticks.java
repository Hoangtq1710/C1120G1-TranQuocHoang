package hackkerrank_method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {
    static int[] cutTheSticks(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr.length);
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i -1]) {
                list.add(arr.length -i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 2, 2, 8};
        System.out.println(Arrays.toString(cutTheSticks(arr)));
    }
}
