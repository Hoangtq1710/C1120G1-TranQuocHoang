package com.soren.service;

import com.soren.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Integer id);
}
