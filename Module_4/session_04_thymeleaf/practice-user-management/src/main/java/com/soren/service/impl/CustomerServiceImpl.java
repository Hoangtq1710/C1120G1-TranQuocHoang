package com.soren.service.impl;

import com.soren.model.Customer;
import com.soren.repository.CustomerRepository;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public boolean isExistId(int id) {
        return repository.isExistId(id);
    }
}
