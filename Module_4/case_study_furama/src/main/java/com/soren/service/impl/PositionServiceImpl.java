package com.soren.service.impl;

import com.soren.model.Position;
import com.soren.repository.PositionRepository;
import com.soren.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }
}
