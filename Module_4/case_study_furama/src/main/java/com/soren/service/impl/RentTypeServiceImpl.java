package com.soren.service.impl;

import com.soren.model.RentType;
import com.soren.repository.RentTypeRepository;
import com.soren.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    RentTypeRepository repository;

    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
