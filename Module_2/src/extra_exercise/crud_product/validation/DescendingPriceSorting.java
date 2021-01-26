package extra_exercise.crud_product.validation;

import extra_exercise.crud_product.models.Product;

import java.util.Comparator;

public class DescendingPriceSorting implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
