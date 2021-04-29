package com.soren.service.impl;

import com.soren.model.ProductType;
import com.soren.repository.ProductTypeRepository;
import com.soren.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl  implements ProductTypeService {
    @Autowired
    private ProductTypeRepository repository;

    @Override
    public List<ProductType> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
