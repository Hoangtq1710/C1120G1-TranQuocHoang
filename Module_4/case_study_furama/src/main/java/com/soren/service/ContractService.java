package com.soren.service;

import com.soren.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    List<Contract> findAll();

    Contract findById(Integer id);

    void save(Contract contract);

    void deleteById(Integer id);

    String getTotalMoney(Contract contract);

    Page<Contract> getListUsingCustomer(String date, Pageable pageable);

    String getCurrentDate(); // method de lay ve thoi gian ngay hien tai theo format yyyy-MM-dd
}
