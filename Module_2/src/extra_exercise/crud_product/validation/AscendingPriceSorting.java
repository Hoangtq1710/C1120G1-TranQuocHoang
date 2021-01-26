package extra_exercise.crud_product.validation;

import extra_exercise.crud_product.models.Product;

import java.util.Comparator;

public class AscendingPriceSorting implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
