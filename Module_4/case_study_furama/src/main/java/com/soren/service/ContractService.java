package com.soren.service;

import com.soren.model.Contract;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    Contract findById(Integer id);

    void save(Contract contract);

    void deleteById(Integer id);

    double getTotalMoney(Contract contract);
}
