package com.soren.service;

import com.soren.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(int id);
}
