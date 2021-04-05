package com.soren.ss06_practice_customer.serivce;

import com.soren.ss06_practice_customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void deleteById(Integer id);

}
