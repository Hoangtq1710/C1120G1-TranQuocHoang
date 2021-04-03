package com.soren.repository;

import com.soren.model.Product;

import java.util.List;

public interface ProductRepository {
    
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
