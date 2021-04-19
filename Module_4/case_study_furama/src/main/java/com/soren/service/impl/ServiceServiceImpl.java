package com.soren.service.impl;

import com.soren.repository.ServiceRepository;
import com.soren.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository repository;

    @Override
    public List<com.soren.model.Service> findAll() {
        return repository.findAll();
    }

    @Override
    public com.soren.model.Service findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(com.soren.model.Service service) {
        repository.save(service);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public String createServiceName(com.soren.model.Service service) {
        String name = service.getServiceType().getServiceTypeName();
        name += service.getServiceId().substring(2, 7);
        return name;
    }
}
