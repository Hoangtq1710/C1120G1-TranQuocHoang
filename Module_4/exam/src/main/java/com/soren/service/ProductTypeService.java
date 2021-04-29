package com.soren.service;

import com.soren.model.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> findAll();

    ProductType findById(Integer id);
}
