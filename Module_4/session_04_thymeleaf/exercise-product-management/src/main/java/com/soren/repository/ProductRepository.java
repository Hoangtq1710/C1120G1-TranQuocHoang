package com.soren.repository;

import com.soren.model.Product;

import java.util.List;

public interface ProductRepository extends CRUDInterface<Product>{
    @Override
    List<Product> findAll();

    @Override
    void save(Product product);

    @Override
    Product findById(int id);

    @Override
    void update(int id, Product product);

    @Override
    void remove(int id);
}
