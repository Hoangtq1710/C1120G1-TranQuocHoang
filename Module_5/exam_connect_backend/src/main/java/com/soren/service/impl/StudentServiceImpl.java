package com.soren.service;

import com.soren.model.Student;
import com.soren.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
