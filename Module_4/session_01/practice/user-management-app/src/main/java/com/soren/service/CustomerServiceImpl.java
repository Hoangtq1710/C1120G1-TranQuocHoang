package com.soren.service;

import com.soren.model.Customer;
import com.soren.repository.CustomerRepository;
import com.soren.repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepository repository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
