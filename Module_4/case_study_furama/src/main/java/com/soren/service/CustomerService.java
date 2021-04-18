package com.soren.service;

import com.soren.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(String id);

    void save(Customer customer);

    void deleteById(String id);
}
