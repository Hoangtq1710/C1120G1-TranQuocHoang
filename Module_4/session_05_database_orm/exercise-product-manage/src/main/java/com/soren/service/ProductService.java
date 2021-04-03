package com.soren.service;

import com.soren.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
