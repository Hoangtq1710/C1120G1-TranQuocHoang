package com.soren.service;

import com.soren.model.Smartphone;
import com.soren.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService{

    @Autowired
    SmartphoneRepository repository;

    @Override
    public Page<Smartphone> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Smartphone findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone smartphone) {
        repository.save(smartphone);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
