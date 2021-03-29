package com.soren.repository;

import com.soren.model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

}
