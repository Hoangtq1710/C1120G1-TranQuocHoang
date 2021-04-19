package com.soren.service.impl;

import com.soren.model.Division;
import com.soren.repository.DivisionRepository;
import com.soren.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepository repository;

    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }
}
