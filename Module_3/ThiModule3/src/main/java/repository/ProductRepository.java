package repository;

import model.Product;

import java.sql.Date;
import java.util.List;

public interface ProductRepository {

    List<Product> findAllProduct();

    Product findById(int id);

    void save(Product product);

    List<Product> topView(int number);

    List<Product> distance(Date start, Date end);

}
