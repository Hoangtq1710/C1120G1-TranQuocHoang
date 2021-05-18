package com.soren.service.impl;

import com.soren.model.Teacher;
import com.soren.repository.TeacherRepository;
import com.soren.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository repository;

    @Override
    public List<Teacher> findAll() {
        return repository.findAll();
    }
}
