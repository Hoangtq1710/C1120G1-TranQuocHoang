package com.soren.service;

import com.soren.model.Product;
import com.soren.repository.CRUDInterface;

import java.util.List;

public interface ProductService extends CRUDInterface<Product> {
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

    @Override
    boolean isExistId(int id);
}
