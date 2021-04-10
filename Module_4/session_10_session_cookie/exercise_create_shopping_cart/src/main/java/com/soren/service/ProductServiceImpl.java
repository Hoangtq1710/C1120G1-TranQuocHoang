package com.soren.service;

import com.soren.model.Product;
import com.soren.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
