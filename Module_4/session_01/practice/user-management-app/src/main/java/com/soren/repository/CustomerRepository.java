package com.soren.repository;

import com.soren.model.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void update(int id, Customer customer);
}
