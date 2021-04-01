package com.soren.repository;

import com.soren.model.Customer;

import java.util.List;

public interface CustomerRepository extends CRUDInterface<Customer> {

    @Override
    List<Customer> findAll();

    @Override
    void save(Customer customer);

    @Override
    Customer findById(int id);

    @Override
    void update(int id, Customer customer);

    @Override
    void remove(int id);

    @Override
    boolean isExistId(int id);
}
