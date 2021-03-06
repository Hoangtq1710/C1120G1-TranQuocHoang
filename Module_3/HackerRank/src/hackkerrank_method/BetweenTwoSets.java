package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class BetweenTwoSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int count = 0;
        for (int i = a.get(0); i <= b.get(0); i++) {
            boolean flag = true;
            for (int aElement : a) {
                if (i % aElement != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                c.add(i);
            }
        }
        System.out.println(c);

        for(int cElement : c) {
            boolean flag = true;
            for(int bElement : b) {
                if (bElement % cElement != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(16);
        b.add(32);
        b.add(96);
        System.out.println(getTotalX(a,b));
    }
}
