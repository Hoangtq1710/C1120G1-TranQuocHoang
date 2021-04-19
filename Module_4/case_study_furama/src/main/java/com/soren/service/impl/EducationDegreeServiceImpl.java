package com.soren.service.impl;

import com.soren.model.EducationDegree;
import com.soren.repository.EducationDegreeRepository;
import com.soren.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    EducationDegreeRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
