package com.soren.service;

import com.soren.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAllList();

    Customer findById(String id);

    void save(Customer customer);

    void deleteById(String id);

    Page<Customer> findAllByCustomerNameContaining(String search, Pageable pageable);
}
