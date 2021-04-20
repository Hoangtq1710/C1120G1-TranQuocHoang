package com.soren.repository;

import com.soren.model.Contract;
import com.soren.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

    List<ContractDetail> findAllByContract(Contract contract);
}
