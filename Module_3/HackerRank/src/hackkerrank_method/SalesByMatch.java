package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class SalesByMatch {
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        List<Integer> listExsist = new ArrayList<>();
        for (int element : ar) {
            int count = 0;
            if (!listExsist.contains(element)) {
                listExsist.add(element);
                for (int run : ar) {
                    if (run == element) {
                        count++;
                    }
                }
                pairs += count/2;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(9,array));
    }
}
