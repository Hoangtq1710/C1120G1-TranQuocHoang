package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.sql.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductRepository repository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAllProduct() {
        return repository.findAllProduct();
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> topView(int number) {
        return repository.topView(number);
    }

    @Override
    public List<Product> distance(Date start, Date end) {
        return repository.distance(start, end);
    }

}
