package com.soren.repository.impl;

import com.soren.model.Product;
import com.soren.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> map;

    static {
        map = new HashMap<>();
        map.put(1, new Product(1,"Sony", 750,"Product of Sony", "Sony Inc"));
        map.put(2, new Product(2,"Oppo", 700,"Product of Oppo", "Oppo Inc"));
        map.put(3, new Product(3,"Iphone", 850,"Product of Apple", "Apple Inc"));
        map.put(4, new Product(4,"Xiaomi", 900,"Product of Xiaomi", "Xiaomi Inc"));
        map.put(5, new Product(5,"Panasonic", 650,"Product of Panasonic", "Panasonic Inc"));
        map.put(6, new Product(6,"Hitachi", 450,"Product of Hitachi", "Hitachi Inc"));
        map.put(7, new Product(7,"Samsung", 950,"Product of Samsung", "Samsung Inc"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Product product) {
        List<Product> listProduct = findAll();
        int id = listProduct.get(listProduct.size() -1).getId() +1;
        product.setId(id);
        map.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public void update(int id, Product product) {
        map.put(id, product);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }
}
