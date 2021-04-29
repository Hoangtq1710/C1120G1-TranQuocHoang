package com.soren.service.impl;

import com.soren.model.Customer;
import com.soren.model.Transaction;
import com.soren.model.TransactionType;
import com.soren.repository.CustomerRepository;
import com.soren.repository.TransactionRepository;
import com.soren.repository.TransactionTypeRepository;
import com.soren.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionTypeRepository typeRepository;

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Transaction> getListFilter(TransactionType transactionType, Customer customer, Pageable pageable) {
        if (transactionType != null && customer != null) {
            return repository.findAllByCustomerAndTransactionType(customer,transactionType, pageable);
        }
        if (transactionType == null && customer == null) {
            return repository.findAll(pageable);
        }
        if (transactionType == null){
            return repository.findAllByCustomer(customer, pageable);
        } else {
            return repository.findAllByTransactionType(transactionType, pageable);
        }
    }

    @Override
    public Transaction findById(String id) {
        return repository.findById(id). orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        repository.save(transaction);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
