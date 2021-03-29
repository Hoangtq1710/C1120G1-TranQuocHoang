package com.soren.service;

import com.soren.model.Customer;
import com.soren.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        repository.update(id, customer);
    }
}
