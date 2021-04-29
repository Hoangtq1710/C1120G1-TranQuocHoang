package com.soren.repository;

import com.soren.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value =  "select * from contract " +
                    "where `date` >= ?1 and `date` <= ?2 ",
            nativeQuery = true)
    Page<Contract> getListFromTo(String from, String to,Pageable pageable);

    @Query(value =  "select * from contract  " +
                    "order by contract.total desc " +
                    "limit ?1",
            nativeQuery = true)
    List<Contract> getTopContract(Integer top);
}
