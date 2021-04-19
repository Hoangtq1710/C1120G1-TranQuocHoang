package com.soren.service;

import com.soren.model.Service;

import java.util.List;

public interface ServiceService {

    List<Service> findAll();

    Service findById(String id);

    void save(Service service);

    void deleteById(String id);

    String createServiceName(Service service);
}
