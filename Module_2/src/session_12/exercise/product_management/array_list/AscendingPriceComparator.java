package session_12.exercise.product_management.array_list;

import java.util.Comparator;

public class AscendingPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product pro1, Product pro2) {
        if (pro1.getPrice() > pro2.getPrice()) {
            return 1;
        } else if (pro1.getPrice() < pro2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
