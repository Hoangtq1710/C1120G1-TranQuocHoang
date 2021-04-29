package com.soren.service;

import com.soren.model.Customer;
import com.soren.model.Transaction;
import com.soren.model.TransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    Page<Transaction> findAll(Pageable pageable);

    Page<Transaction> getListFilter(TransactionType transactionType, Customer customer, Pageable pageable);

    Transaction findById(String id);

    void save(Transaction transaction);

    void deleteById(String id);
}
