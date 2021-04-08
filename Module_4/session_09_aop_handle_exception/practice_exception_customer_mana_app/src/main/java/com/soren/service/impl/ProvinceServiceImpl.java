package com.soren.ss07_practice_customer_province.service.impl;

import com.soren.ss07_practice_customer_province.model.Province;
import com.soren.ss07_practice_customer_province.repository.ProvinceRepository;
import com.soren.ss07_practice_customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }
}
