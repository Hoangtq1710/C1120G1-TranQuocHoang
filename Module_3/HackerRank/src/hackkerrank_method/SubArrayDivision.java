package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class SubArrayDivision {
    static int birthday(List<Integer> s, int d, int m) {
        int wayCount = 0;
        int[] array = new int[m];
        for (int i = 0; i <= (s.size() - m); i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                array[j] = s.get(i + j);
                sum += array[j];
            }
            if (sum == d) {
                wayCount++;
            }
        }
        return wayCount;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);

//        list.add(2);
//        list.add(3);
//        list.add(2);
//        list.add(1);

        System.out.println(birthday(list,4,1));
    }
}
