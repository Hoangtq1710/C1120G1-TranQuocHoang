package com.soren.service.impl;

import com.soren.model.TransactionType;
import com.soren.repository.TransactionTypeRepository;
import com.soren.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    @Autowired
    private TransactionTypeRepository repository;

    @Override
    public List<TransactionType> findAll() {
        return repository.findAll();
    }

    @Override
    public TransactionType findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
