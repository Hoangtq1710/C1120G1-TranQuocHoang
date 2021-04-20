package com.soren.service.impl;

import com.soren.model.AttachService;
import com.soren.repository.AttachServiceRepository;
import com.soren.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository repository;

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }
}
