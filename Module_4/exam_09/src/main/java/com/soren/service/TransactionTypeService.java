package com.soren.service;

import com.soren.model.TransactionType;

import java.util.List;

public interface TransactionTypeService {

    List<TransactionType> findAll();

    TransactionType findById(Integer id);
}
