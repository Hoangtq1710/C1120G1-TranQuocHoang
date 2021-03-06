package hackkerrank_method;

import java.util.ArrayList;
import java.util.List;

public class BillDivision {
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int rightCount = 0;
        for (Integer cost : bill) {
            rightCount += cost;
        }
        rightCount = (rightCount - bill.get(k)) /2;
        if (b > rightCount) {
            System.out.println(b - rightCount);
        } else if (b == rightCount) {
            System.out.println("Bon Appetit");
        }
    }

    public static void main(String[] args) {
        List<Integer> listBill = new ArrayList<>();
        listBill.add(3);
        listBill.add(10);
        listBill.add(2);
        listBill.add(9);
        bonAppetit(listBill,1,12);
    }
}
