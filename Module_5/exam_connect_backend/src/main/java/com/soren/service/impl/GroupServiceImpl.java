package com.soren.service.impl;

import com.soren.model.Group;
import com.soren.repository.GroupRepository;
import com.soren.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository repository;

    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }
}
