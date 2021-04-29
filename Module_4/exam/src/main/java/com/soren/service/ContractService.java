package com.soren.service;

import com.soren.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> getListFromTo(String from, String to,Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> getTopContract(Integer top);

    Double getTotal(Contract contract);

}
