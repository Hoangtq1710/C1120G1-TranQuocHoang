package com.soren.service.impl;

import com.soren.model.Customer;
import com.soren.repository.CustomerRepository;
import com.soren.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) throws Exception {
        if (true){
            throw new Exception("a findById Exception");
        }
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) throws Exception {
        if (true){
            throw new Exception("a save Exception");
        }
        repository.save(customer);
    }

    @Override
    public void remove(Integer id) throws Exception {
        if (true){
            throw new Exception("a delete Exception");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Customer> findAllByProvinceName(String name) {
        return repository.findAllByProvinceName(name);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return repository.findAllByNameContaining(name, pageable);
    }


}
