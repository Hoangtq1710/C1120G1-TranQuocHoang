package com.soren.service.impl;

import com.soren.model.Contract;
import com.soren.repository.ContractRepository;
import com.soren.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Contract> getListFromTo(String from, String to, Pageable pageable) {
        return repository.getListFromTo(from, to, pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        repository.save(contract);
    }

    @Override
    public List<Contract> getTopContract(Integer top) {
        return repository.getTopContract(top);
    }

    @Override
    public Double getTotal(Contract contract) {
        return Double.parseDouble(contract.getProduct().getCost()) * Double.parseDouble(contract.getQuantity());
    }
}
