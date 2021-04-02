package com.soren.repository;

import com.soren.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void delete(int id);
}
