package com.soren.service;

import com.soren.model.Customer;
import com.soren.repository.CRUDInterface;

import java.util.List;

public interface CustomerService extends CRUDInterface<Customer> {
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

}
