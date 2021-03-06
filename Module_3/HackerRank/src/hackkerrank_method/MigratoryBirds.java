package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class MigratoryBirds {
    static int migratoryBirds(List<Integer> arr) {
        int[] countArr = new int[5];
        for(int i : arr) {
            switch (i) {
                case 1: countArr[0]++; break;
                case 2: countArr[1]++; break;
                case 3: countArr[2]++; break;
                case 4: countArr[3]++; break;
                case 5: countArr[4]++; break;
            }
        }
        int max = countArr[0];
        int value = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > max) {
                max = countArr[i];
                value = i +1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(migratoryBirds(list));
    }
}
