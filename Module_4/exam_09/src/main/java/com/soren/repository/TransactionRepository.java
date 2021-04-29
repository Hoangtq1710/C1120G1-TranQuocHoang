package com.soren.repository;

import com.soren.model.Customer;
import com.soren.model.Transaction;
import com.soren.model.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Page<Transaction> findAllByTransactionType(TransactionType transactionType, Pageable pageable);

    Page<Transaction> findAllByCustomer(Customer customer, Pageable pageable);

    Page<Transaction> findAllByCustomerAndTransactionType(Customer customer, TransactionType transactionType, Pageable pageable);
}
