package com.soren.service;

import com.soren.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    void deleteById(Integer id);

    List<Student> fullSearch(String q);
}
