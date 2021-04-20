package com.soren.repository;

import com.soren.model.Contract;
import com.soren.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findAllByCustomerNameContaining(String search, Pageable pageable);
}
