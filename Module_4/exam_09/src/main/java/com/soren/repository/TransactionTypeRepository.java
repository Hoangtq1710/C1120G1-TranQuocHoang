package com.soren.repository;

import com.soren.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {
}
