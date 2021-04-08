package com.soren.ss07_practice_customer_province.service;

import com.soren.ss07_practice_customer_province.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    List<Customer> findAllByProvinceName(String name);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
