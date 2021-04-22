package com.soren.service;

import com.soren.model.Contract;
import com.soren.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAllList();

    Customer findById(String id);

    void save(Customer customer);

    void checkCustomerId(Customer customer, Errors errors );

    void deleteById(String id);

    Page<Customer> findAllByCustomerNameContaining(String search, Pageable pageable);
}
