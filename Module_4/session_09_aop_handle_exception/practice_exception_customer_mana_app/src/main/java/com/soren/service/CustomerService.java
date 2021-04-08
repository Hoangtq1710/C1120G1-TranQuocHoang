package com.soren.service;

import com.soren.model.Customer;
import com.soren.service.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Integer id);

    void save(Customer customer) throws DuplicateEmailException;

    void remove(Integer id);

    List<Customer> findAllByProvinceName(String name);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
