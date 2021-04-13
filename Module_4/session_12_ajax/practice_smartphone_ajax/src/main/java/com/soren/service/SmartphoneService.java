package com.soren.service;

import com.soren.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SmartphoneService {

    Page<Smartphone> findAll(Pageable pageable);

    Smartphone findById(Integer id);

    void save(Smartphone smartphone);

    void deleteById(Integer id);
}
