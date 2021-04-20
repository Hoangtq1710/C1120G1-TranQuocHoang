package com.soren.service;

import com.soren.model.Contract;
import com.soren.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {

    List<ContractDetail> findAll();

    List<ContractDetail> findAllByContract(Contract contract);

    void save(ContractDetail contractDetail);
}
