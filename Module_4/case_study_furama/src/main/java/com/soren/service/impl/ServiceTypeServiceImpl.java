package com.soren.service.impl;

import com.soren.model.ServiceType;
import com.soren.repository.ServiceTypeRepository;
import com.soren.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    ServiceTypeRepository repository;

    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }
}
