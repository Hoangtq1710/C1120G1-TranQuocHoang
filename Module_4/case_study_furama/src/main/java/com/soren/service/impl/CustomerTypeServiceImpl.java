package com.soren.service.impl;

import com.soren.model.CustomerType;
import com.soren.repository.CustomerTypeRepository;
import com.soren.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
