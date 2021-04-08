package com.soren.service.impl;

import com.soren.model.Province;
import com.soren.repository.ProvinceRepository;
import com.soren.service.ProvinceService;
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
